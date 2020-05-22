ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode consolidated_weather =root.get("consolidated_weather");
        consolidated_weather.forEach(x -> {

            System.out.println( x.get("weather_state_name"));
        });