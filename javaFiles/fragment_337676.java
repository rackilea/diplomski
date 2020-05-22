public class WeatherConditions {
    int id;
    String name;
    WeatherMain main;

    class WeatherMain {
        float temp;
        float feels_like;
        float temp_min;
        float temp_max;
        float pressure;
        float humidity;

        public String displayWeatherMain() {
            String temperature;
            temperature = "Temp: " + temp + "\nPressure: " + pressure + "\nHumidity: " + humidity +
                "\nTemp_max: " + temp_max + "\nTemp_min: " + temp_min;
            return temperature;
        }

        public HashMap<String, float> weatherMainAsHashMap() {
            HashMap res = new HashMap<String, float>();
            res.put("temp", temp);
            res.put("feels_like", feels_like);
            res.put("temp_min", temp_min);
            res.put("temp_max", temp_max);
            res.put("pressure", pressure);
            res.put("humidity", humidity);
            return res;
        }
    }

    public String displayWeatherConditions() {
        String temp;

        temp = "ID: " + id + "\nName: " + name + "\n" + main.displayWeatherMain();
        return temp;
    }
}