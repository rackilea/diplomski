try
{
 String query = "select * from emp;*;
 ResultSet rs = stmt.executeQuery(query);

 while(rs.next())
     {
      String []sections = new String[30];
      for(int i = 0; i < 30; i++)
      {
      sections[i] = rs.getString(i+1);
      }
     //now add your checking logic here...
     }
    }
catch(Exception e)
{
 e.printStackTrace();
}