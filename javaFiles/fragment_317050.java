public void getData()
{
  try{
            ps=con.prepareStatement("select * from tbl_name");

            rs=ps.executeQuery();
            while(rs.next())
            {
                System.out.println(rs.getString(1)); //here you can get data, the '1' indicates column number based on your query

            }

      }
      catch(Exception e)
      {
          System.out.println("Error in getData"+e);
      }

}