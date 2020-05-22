package com.sample.demo;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DemoApplicationTests {

    public static void main(String args[]) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String response = "{\n" + "\"coord\": {\n" + "    \"lon\": 26.94,\n" + "    \"lat\": 43.27\n" + "},\n"
                + "\"weather\": [\n" + "    {\n" + "        \"id\": 802,\n" + "        \"main\": \"Clouds\",\n"
                + "        \"description\": \"scattered clouds\",\n" + "        \"icon\": \"03d\"\n" + "    }\n"
                + "],\n" + "\"base\": \"model\",\n" + "\"main\": {\n" + "    \"temp\": 19.3,\n"
                + "    \"pressure\": 1012,\n" + "    \"humidity\": 66,\n" + "    \"temp_min\": 19.3,\n"
                + "    \"temp_max\": 19.3,\n" + "    \"sea_level\": 1012,\n" + "    \"grnd_level\": 971\n" + "},\n"
                + "\"wind\": {\n" + "    \"speed\": 6.91,\n" + "    \"deg\": 182\n" + "},\n" + "\"clouds\": {\n"
                + "    \"all\": 38\n" + "},\n" + "\"dt\": 1573204594,\n" + "\"sys\": {\n" + "    \"country\": \"BG\",\n"
                + "    \"sunrise\": 1573188939,\n" + "    \"sunset\": 1573224978\n" + "},\n" + "\"timezone\": 7200,\n"
                + "\"id\": 727233,\n" + "\"name\": \"Shumen\",\n" + "\"cod\": 200\n" + "}";
        Weather weather = objectMapper.readValue(response, Weather.class);
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Weather {
    @JsonProperty("name")
    private String cityName;
    private String type; // for weather type eg: Cloudy, Sunny, Raining etc...
    private float temp;
    private float tempMin;
    private float tempMax;
    private float windSpeed;
    private String icon;
    private float lon;
    private float lat;

    @JsonIgnoreProperties("base")
    public Weather() {
    }

    @JsonProperty("main")
    private void unpackMain(Map<String, String> main) {
        temp = Float.parseFloat(main.get("temp"));
        tempMin = Float.parseFloat(main.get("temp_min"));
        tempMax = Float.parseFloat(main.get("temp_max"));
    }

    @JsonProperty("coord")
    private void unpackCoord(Map<String, String> coord) {
        lon = Float.parseFloat(coord.get("lon"));
        lat = Float.parseFloat(coord.get("lat"));
    }

    @JsonProperty("weather")
    private void unpackWeather(List<Map<String, String>> weather) {
        System.out.println(weather);
        type = weather.get(0).get("main"); // Taken first element , change as per your requirement
        icon = weather.get(0).get("icon");
    }
}