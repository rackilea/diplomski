public class Laureates {
    int id;
    String firstname;
    String surname;
    @JsonAdapter(DateDeserializer.class)
    Date born;
    @JsonAdapter(DateDeserializer.class)
    Date died;
    String bornCountry;
    String bornCountryCode;
    String bornCity;
    String diedCountry;
    String diedCountryCode;
    String diedCity;
    String gender;
    List<Prizes> prizes;
...Getters/Setters

}