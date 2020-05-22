@Configuration
public class BeanConfig {

    @Bean
    public Map<Integer, WeatherDays> totalDays() {
        Map<Integer, WeatherDays> map = new HashMap<>();
        map.put(1, WeatherDays.DRY);
        return map;
    }

    @Bean
    public Map<Integer, Double> maxRainyDays() {
        Map<Integer, Double> map = new HashMap<>();
        map.put(1, 0.2);
        return map;
    }
}