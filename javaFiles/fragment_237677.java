class Controller {

    //New transaction
    CustomerEntity customerEntity = (CustomerEntity) customerService.getCustomerFromLeadId(id);
    //New transaction
    AddressEntity resAddressEntity = (AddressEntity) addressService.getResAddress(customerEntity.getSomeId());
    //New transaction
    AddressEntity offAddressEntity = (AddressEntity) addressService.getOffAddress(customerEntity.getSomeId());
    //New transaction / if something goes wrong no rollback for previous transactions
    List<KeyContactsEntity> listKeyContacts = keyContactService.getKeyContactOfClient(customerEntity.getSomeId());

}