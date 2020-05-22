private String weather;
private double temperature;
private int humidity;
public void WeatherDTO(Map<?, ?> mappedJsonData) {
    if (mappedJsonData == null || mappedJsonData.isEmpty()) {
        return;
    }

    List<?> weather = (List<?>) mappedJsonData.get("weather");
    if (weather != null && !weather.isEmpty()) {
        this.weather = (String) ((Map<?, ?>) weather.get(0)).get("description");
    }

    Map<?, ?> jsonMain = (Map<?, ?>) mappedJsonData.get("main");
    if (jsonMain != null && !jsonMain.isEmpty()) {
        this.temperature = (Double) jsonMain.get("temp") - 273.0;
        this.humidity = (Integer) jsonMain.get("humidity");
    }
}