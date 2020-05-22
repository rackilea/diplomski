@Mappings(
            @Mapping(target = "address.country", source = "countryEntity")
    )
    CustomerEntity fromSubmitCustomerDetailsRequestToCustomerEntity(SubmitCustomerDetailsRequest request, CountryEntity countryEntity);

    @Mappings(
            @Mapping(target = "address.country", source = "customerEntity.address.country.country")
    )
    GetCustomerDetailsResponse fromCustomerEntityToGetCustomerDetailsResponse(CustomerEntity customerEntity);