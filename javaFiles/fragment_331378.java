<body>
<%
String taxg=null,nameg=null,valg=null;
String id = null;
String row = request.getParameter("rowCount");   
System.out.println("Row Count====="+row);
int rowCount = Integer.parseInt(row);
String hiddenvalue = request.getParameter("hiddenvalue");
int hid = Integer.parseInt(hiddenvalue);
System.out.println("hidden are:"+hid);
String taxgroup=null,name=null;
String value=null;
String[] group = request.getParameterValues("group");
String[] taxname = request.getParameterValues("taxname");
String[] me = request.getParameterValues("me");

int j=1;
int k=0;

while (j < rowCount) {
    name = request.getParameter("name" + j);
    taxgroup = request.getParameter("taxgroup" + j);
    value = request.getParameter("value" + j);
System.out.println("value is"+value);
if((name!=null) && (taxgroup!=null) && (value!=null)) {
try{
      DBConnect db =new DBConnect();
      Connection con = db.getCon();
      String sql ="INSERT INTO marketing_database.tax_info (TaxGroup,Name,Value) values (?,?,?);";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, taxgroup);
      ps.setString(2, name);
      ps.setString(3, value);
    ps.executeUpdate();
    System.out.println(" Saved to tax_info !!");
   con.close();
   ps.close();
} catch (SQLException ex) {
ex.printStackTrace();
}

j = j + 1;
}
}

while(k < hid) {
try {
    DBConnect db1 = new DBConnect();
     Connection con1 = db1.getCon();
     Statement st1 = con1.createStatement();
     String query1 = "Select id,TaxGroup,Name,Value from marketing_database.tax_info ORDER BY id;";
     ResultSet rs1 = st1.executeQuery(query1);
     while (rs1.next()) {
         taxg = rs1.getString(2);
         nameg = rs1.getString(3);
         valg = rs1.getString(4);
         id = rs1.getString(1);
         System.out.println(id);


    String group1 = group[k];
    String taxname1  = taxname[k];
    String value2 = me[k];
     System.out.println(group1);
    try{
          DBConnect db2 =new DBConnect();
          Connection con2 = db2.getCon();
          String sql1 ="Update marketing_database.tax_info set TaxGroup = '"+group1+"', Name = '"+taxname1+"', Value= '"+value2+"' where id = '"+id+"'";
          PreparedStatement ps1 = con2.prepareStatement(sql1);
          ps1.executeUpdate();
        System.out.println(" Saved to database !!");

       con2.close();
       ps1.close();


    } catch (SQLException ex) {
    ex.printStackTrace();
    }

    k = k + 1;
     }
     con1.close();
     st1.close();
     rs1.close();
  } catch (Exception e) {
    e.printStackTrace();
  }
}

response.sendRedirect("taxInfo.jsp");
%>

</body>