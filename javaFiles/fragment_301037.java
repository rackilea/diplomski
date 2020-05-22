public class Country {

    private City city;

    public City getCity() {
        if (this.city == null) {
            this.city = new City();
        }

        return this.city;
    }

}