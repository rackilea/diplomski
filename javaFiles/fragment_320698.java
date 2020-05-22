String str = "FACTURA MTY10745/24";
String query = "Select DATE_COMP From ELP_DEALER_RECON_WRK WHERE CERTIFICATE = ?";
//-----------------------------------------------------------------------------^
try(PreparedStatement pst = con.prepareStatement(query)){
    pst.setString(1, str);// Set the input
    ResultSet result = pst.executeQuery();
    //... get results
}