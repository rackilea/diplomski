public class Address {
    @XmlElement(name = "StreetAddress", namespace = "http://example.org")
    private String streetAddress;
    @XmlElement(name = "PostalCode", namespace = "http://example.org")
    private String postalCode;
    @XmlElement(name = "CountryName", namespace = "http://example.org")
    private String countryName;

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountryName() {
        return countryName;
    }
}