public class EventsAndShifts{    

  //i noticed you wanted to insert the event id for a shift, you can't do it the way you wanted to, you have to do it like this (this method will return an int)
public int setEventInfo(String title, String description, String start, String end, String guestNo){
     int eventID = 0; //initialize
    //get connection from our DBConneciton class we created earlier
    try(Connection conn= DBConnection.getConnection()){
//returning the generated keys lets us get the row id of what we insert
   PreparedStatement pst = conn.prepareStatement("INSERT INTO event(title, description, start, end, guest_no) VALUES(?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS); 

         pst.setString(1, title);
         pst.setString(2, description);
         pst.setString(3, start); 
         pst.setString(4, end);
         pst.setInt(5, Integer.parseInt(guestNo));

         pst.executeUpdate();   
       //now get the eventID
    ResultSet rs = pst.getGeneratedKeys();
    while (rs.next()) {
    eventID = rs.getInt(1); //get the id of the inserted event
      }

        } catch (SQLException e) {
            e.printStackTrace();
        }
     //we don't need to close our db connection because the try statement does it for us   
return eventID; //return the eventID
}   




public void setShiftInfo(int eventID, String ss, String es, String pos){
    //get connection from our DBConneciton class we created earlier
    try(Connection conn= DBConnection.getConnection()){
   PreparedStatement pst = conn.prepareStatement("INSERT INTO shift(event_id, start, end, positions)VALUES(?, ?, ?, ?);"); 

         pst.setInt(1, eventID);    
         pst.setString(2, ss);
         pst.setString(3, es);
         pst.setInt(4, Integer.parseInt(pos));

         pst.executeUpdate();   

        } catch (SQLException e) {
            e.printStackTrace();
        }
}  



}