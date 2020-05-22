Statement st = con.createStatement();
ResultSet rs=st.executeQuery("select * from ABC");
while(rs.next()) 
{
    String str= DatatypeConverter.printHexBinary(resultSet.getRowId(1).getBytes())       
    System.out.println(str);
}