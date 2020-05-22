//Assuming you have a Connection conn;
 PreparedStatement groupsPS = 
     conn.prepareStatement("SELECT distinct pos from yourtable");
 ResultSet groupsRS = groupsPS.executeQuery();
 PreparedStatement groupdataPS = 
     conn.prepareStatement("SELECT * from yourtable where pos = ?");
 ResultSet groupdataRS = null;

 while(groupsRS.next())
 {
    groupdataPS.setString(1, groupsRS.getString("pos"));
    groupdataRS = groupdataPS.executeQuery();
    while(groupsRS.next())
    {
      //process your data here
    }
    groupdataRS.close();
 }
 groupsRS.close();
 groupdataPS.close();
 groupsPS.close();