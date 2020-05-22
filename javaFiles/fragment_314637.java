PreparedStatement ps1 = c11.createConnection().prepareStatement("SELECT staff_id FROM staff");
ResultSet rst=ps1.executeQuery();
rst.last()
{
 stafid= rst.getString("staff_id");
}while(rst.previous());