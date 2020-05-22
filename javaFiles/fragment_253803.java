List<Flight> flights = new ArrayList<Flight>();
while(rs.next()){
    Flight flight = new Flight();
    flight.setColumn1(rs.getString(1));   // Its better to use column name instead to avoid any unexpected bug
    flight.setColumn2(rs.getString(2));   // Its better to use column name instead to avoid any unexpected bug 
}