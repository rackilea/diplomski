// the statement is only prepared, not executed!
PreparedStatement pstmt = con.prepareStatement("select * from foo");

ResultSetMetaData metaData = pstmt.getMetaData();
for (int i=1; i <= metaData.getColumnCount(); i++)
{
  System.out.println(metaData.getColumnName(i));
}