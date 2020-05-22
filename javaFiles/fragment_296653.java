public class Movie {

    private Production prodCompany;

    public Movie() {
        prodCompany = new Production();
    }

    public void setProdCompany(String someName, String someCity, String someState) {
        prodCompany.setCompanyName(someName);
        prodCompany.setLocationCity(someCity);
        prodCompany.setLocationState(someState);
    }
...