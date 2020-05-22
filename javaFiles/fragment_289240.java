public List<BusinessPartner> getBusinessPartnersByEmail(
    @Nonnull BusinessPartnerService service,
    @Nonnull String email
)
    throws ODataException
{
    List<AddressEmailAddress> emailAddresses = service
        .getAllAddressEmailAddress()
        .filter(AddressEmailAddress.SEARCH_EMAIL_ADDRESS.eq(email))
        .execute();

    List<BusinessPartnerAddress> addresses = new LinkedList<>();
    for( AddressEmailAddress emailAddress : emailAddresses ) {
        addresses.addAll(
            service
                .getAllBusinessPartnerAddress()
                .filter(BusinessPartnerAddress.ADDRESS_ID.eq(emailAddress.getAddressID()))
                .execute());
    }

    List<BusinessPartner> businessPartners = new LinkedList<>();
    for( BusinessPartnerAddress address : addresses ) {
        businessPartners.add(service.getBusinessPartnerByKey(address.getBusinessPartner()).execute());
    }

    return businessPartners;
}