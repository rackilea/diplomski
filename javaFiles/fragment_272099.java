String query = 
    "-- a classical comment " +
    "select * " +
    "from MYTABLE ";
ResultSet rs = conMain.createStatement().executeQuery(query);
while(rs.next()) {
    //do something...
}