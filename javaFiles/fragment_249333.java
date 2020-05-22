Connection con = ....; // open the connection
con.setAutoCommit(false);
Statement stmt = con.createStatement();
stmt.setFetchSize(1000);
ResultSet rs = stmt.executeQuery("select ...");
while (rs.next()) 
{
   // do something with the row
}