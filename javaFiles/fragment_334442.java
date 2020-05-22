public class Address {
    @ZipCode.List( {
            @ZipCode(countryCode="fr", groups=Default.class
                     message = "zip code is not valid"),
            @ZipCode(countryCode="fr", groups=SuperUser.class
                     message = "zip code invalid. Requires overriding before saving.")
            } )
    private String zipcode;
}