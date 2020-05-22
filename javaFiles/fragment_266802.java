PreparedStatement pt=connection.prepareStatement("INSERT INTO supply VALUES (?,?,?,?,?,?)")
pt.setString(1,id );
pt.setString(2,idSupplier );
pt.setString(3,dateTime );
pt.setString(4,idProduct );
pt.setString(5,Quantity );
pt.setString(6,price );
int rs2=pt.executeUpdate();