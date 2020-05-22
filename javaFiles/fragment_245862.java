public Customer getCustomerById(int customerID) {

    String sql = "SELECT intCustomerID, vachCustomerTitle, vachCustomerFirstName, vachCustomerSurnames, dteCustomerDOB, vachCustomerAddressStreet, vachCustomerAddressTown, vachCustomerAddressCounty, vachCustomerAddressPostalCode, intCustomerHomePhone, intCustomerWorkPhone, intCustomerMobilePhone, vachCustomerEmail FROM h_customers " + "WHERE" + " intCustomerID=?"; 
    try { 
        st.setInt(1, customerID); 
        rs = st.executeQuery(); 
        while (rs.next()){ 
            Customer customer = new Customer();
            customer.setId(rs.getInt("intCustomerID")); 
            customer.setTitle(rs.getString("vachCustomerTitle")); 
            customer.setFirstName(rs.getString("vachCustomerFirstName")); 
            //...
            return customer;
        } 
    } catch (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); } }
        return null;
    } finally {
        if(rs != null) {
            rs.close();
        }
    }
}