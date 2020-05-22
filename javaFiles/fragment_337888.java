String sqlQuery = "{ call some_procedure(?, ?)}";
  final StructDescriptor structDescriptor = StructDescriptor.createDescriptor("bank_account", conn);        
  final ResultSetMetaData metaData = structDescriptor.getMetaData();
  CallableStatement stmt= conn.prepareCall(sqlQuery);
  stmt.setInt(1, 150);
  stmt.registerOutParameter(2, java.sql.Types.STRUCT, "bank_account");

  stmt.execute();

  Object o = stmt.getObject(2); // this will return an OUT param either as a STRUCT object or a bank_account object. A bank_account will be returned if your Java bank_account class has implemented the SQLData interface.

  for(int i = 1; i <= metaData.getColumnCount(); ++i)
          System.out.println(metaData.getColumnName(i)); //this will print attribute names