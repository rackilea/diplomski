public Customer getCustomer(int id) throws CustomerDataUnavailableException {
    try {
         // access SQL database
         return customer;
     } catch ( SQLException e) {
         throw new CustomerDataUnavailableException(e);
     }
}