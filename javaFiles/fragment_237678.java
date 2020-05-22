@Transactional
   class FacadeService {

    //New transaction
    CustomerEntity customerEntity = (CustomerEntity) customerService.getCustomerFromLeadId(id);
    //Reuse transaction
    AddressEntity resAddressEntity = (AddressEntity) addressService.getResAddress(customerEntity.getSomeId());
    //Reuse transaction
    AddressEntity offAddressEntity = (AddressEntity) addressService.getOffAddress(customerEntity.getSomeId());
    //Reuse transaction / If something goes wrong rollback of everyting
    List<KeyContactsEntity> listKeyContacts = keyContactService.getKeyContactOfClient(customerEntity.getSomeId());

}