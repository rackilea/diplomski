public void testInsertUser(){
ABC.insertUser(User.firstname, user.lastname);
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("SELECT firstname_Colname, lastname_Colname FROM Your_Table");
boolean found = false;
while (rs.next())
{
  found = ((User.firstname = rs.getString("firstname_Colname")) and (User.lastname = rs.getString("lastname_Colname")));
  if (found)
  {
    break;
  }     
}
assertEquals('test failed!', true, found);
}