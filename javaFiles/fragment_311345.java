public interface WeatherDao {

    public Weather getWeather(String zipCode);

    public List<Location> findLocations(String locationSearch);
}

public class DefaultWeatherDao implements WeatherDao {

    @Cacheable(cacheName="weatherCache")
    public Weather getWeather(String zipCode) {
        //Some Code
    }

    @Cacheable(cacheName="locationSearchCache")
    public List<Location> findLocations(String locationSearch) {
        //Some Code
    }
}