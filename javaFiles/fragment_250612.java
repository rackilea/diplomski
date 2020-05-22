public static void main(String args[]) {
    for(CountryDefaultAddressEnum countryAddr : CountryDefaultAddressEnum.values()) {
        System.out.println(countryAddr + ": " + countryAddr.getValue());
    }
}

public enum CountryDefaultAddressEnum {

    // Country or Region , Contact Name, Street Address, City, State, ZIP Code
    US_CAL("US", "CA Address", "2065 Hamilton Avenue", " ", "San Jose", "CA",
            "95125"),
    US_SJ("US", "CA Address", "201 South Fourth Street", " ", "San Jose", "CA",
            "95112");

    private String countryOrRegion;
    private String contactName;
    private String streetAddress;
    private String streetAddress2;
    private String city;
    private String state;
    private String zipCode;

    private CountryDefaultAddressEnum(String countryOrRegion,
            String contactName, String streetAddress, String streetAddress2,
            String city, String state, String zipCode) {
        this.countryOrRegion = countryOrRegion;
        this.contactName = contactName;
        this.streetAddress = streetAddress;
        this.streetAddress2 = streetAddress2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getValue() {
        return String.format("%s %s %s %s %s %s %s", countryOrRegion, contactName, streetAddress, streetAddress2, city, state, zipCode);
    }
}