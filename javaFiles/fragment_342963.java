JDateChooser arrival = new JDateChooser();
JDateChooser departure = new JDateChooser();

PreparedStatement pStmt = conn.prepareStatement("select * from testing.room where arrival_date >= ? and departure_date < ?");
pStmt.setDate(1, arrival.getDate());
pStmt.setDate(2, departure.getDate());
ResultSet rs = preparedStatement.executeQuery();