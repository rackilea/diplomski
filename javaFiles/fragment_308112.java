static void queryCom4j(){ 
  IADs rootDSE = COM4J.getObject(IADs.class, "LDAP://RootDSE", null);
  String namingContext = (String)rootDSE.get("defaultNamingContext");

  _Connection conn = ClassFactory.createConnection();
  conn.provider("ADsDSOObject");
  conn.open("Active Directory Provider","","",-1);

  _Command cmd = ClassFactory.createCommand();
  cmd.activeConnection(conn);

  String fields = "distinguishedName,userPrincipalName,telephoneNumber,mail";
  String query = "(&(objectclass=user)(objectcategory=person))";

  cmd.commandText("<LDAP://" + namingContext + ">;" + query + ";" + fields + ";subTree");
  _Recordset rs = cmd.execute(null, Variant.getMissing(), -1);

  System.out.println("Found " + rs.recordCount() + " users");
  while (!rs.eof()){
      for (int i = 0; i < fields.split(",").length; i++){
          Object value = rs.fields().item(i).value();
          System.out.println((value == null) ? "N/A" : value.toString());
      }
      rs.moveNext();
  }