class Company {
    @JsonUnwrapped(prefix = "postal")
    private Address postalAddress;
    @JsonUnwrapped(prefix = "visitor")
    private Address visitorAddress;
    @JsonUnwrapped(prefix = "Establishment")
    private Address establishmentAddress;
}