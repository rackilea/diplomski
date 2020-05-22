@Transactional(propagation = Propagation.REQUIRES_NEW)
private void readRowFromExcel(Row row){

    for(Row row : sheet){
        //Reading from Excel
        Customer customer = readCustomerFromExcel(row)
        CustomerDeatails customerDetails = readCustomerDetailsFromExcel(row);
        MyEntity myEntity = readMyEntityFromExcel(row);

        //DB persisting
        customerService.save(customer,customerDetails);
        myEntityService.save(myEntity)
    }   

}