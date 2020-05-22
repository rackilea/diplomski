// info for individual city
public class City    {
    String citiesId;
    String city;
    String regionName;
    // and so on
}

// top-level object, containing info for lots of cities
public class CityList  {
    List<City> cities;

    public CityList(List<City> cities) {
        this.cities = cities;
    }
}