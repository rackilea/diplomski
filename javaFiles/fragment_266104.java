ResultSet rs = stmt.executeQuery("select * from usp_sel_article_initialdata_new1()");
if (rs.next())
{
  // first result set returned
  Object o = rs.getObject(1);
  if (o instanceof ResultSet)
  {
    ResultSet rs1 = (ResultSet)o;
    while (rs1.next())
    {
       int id = rs1.getInt(1);
       String name = rs1.getString(2);
       .... retrieve the other columns using the approriate getXXX() calls
    }
  }
}

if (rs.next()) 
{
  // process second ResultSet 
  Object o = rs.getObject(1);
  if (o instanceof ResultSet)
  {
    ResultSet rs2 = (ResultSet)o;
    while (rs2.next())
    {
       ......
    }
  }
}