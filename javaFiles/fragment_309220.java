public class NiceCityFilter implements Filter {

    private String _cityName;

    public NiceCityFilter(String cityName) {
        _cityName = cityName;
    }

    @Override
    public boolean filter(Event event) {
        return cityName.equals(event.getCity());
    }
}