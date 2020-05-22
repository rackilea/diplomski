Connection con = null;
Statement stmt = null;
ResultSet rs = null;
try
{
    con = cpds.getConnection();
    stmt = cpds.createStatement();
    rs = stmt.executeQuery("SELECT something FROM somewhere");
    while ( rs.next() )
    {
       // do some stuff with results
    }
}
finally
{
   try { if (rs != null) rs.close() } catch (SQLException e) { e.printStackTrace(); }
   try { if (stmt != null) stmt.close() } catch (SQLException e) { e.printStackTrace(); }
   try { if (con != null) con.close() } catch (SQLException e) { e.printStackTrace(); }
}