public Event getEvent(String tableClick) {
Events e = new Events();
try {
    pst = conn.prepareStatement("SELECT * FROM Event WHERE eventID='"+tableClick+"' ");
    rs = pst.executeQuery();
    while(rs.next()){      
    e.setEventName(rs.getString(2));
    System.out.println(rs.getString(2));
    e.setEventDate(rs.getDate(3));
    e.setEventTime(rs.getString(4));
    e.setEventVenue(rs.getString(5));
    e.setEventDetail(rs.getString(6));
    e.setEventOpportunity(rs.getString(7));
    e.setEventMoreDetails(rs.getString(8));
    e.setEndTime(rs.getString(9));
    rs.close();
    pst.close();
    return e;
   }
} catch(SQLException ex) {
    ex.printStackTrace();
    return null;
} 

} //end getEvent