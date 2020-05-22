ps = con.prepareStatement("SELECT * FROM Tabel WHERE (ID1=? OR ID2=?) AND ORG=?");
ps.setString(1, id);
ps.setString(2, id);
ps.setString(3, org)
ResultSet rs=ps.executeQuery();
while(rs.next())
{
//use your code to retrieve like rs.getString(1);
}