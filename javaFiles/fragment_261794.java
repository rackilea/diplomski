String url = "https://maps.googleapis.com/maps/api/geocode/json?latlng={latlng}&key={key}";

Map<String, Object> uriVariables = new HashMap<>();
uriVariables.put("latlng", "5.47686,-73.961452");
uriVariables.put("key", "YOUR_API_KEY");

String consumeJSONString =  restTemplate.getForObject(url, String.class, uriVariables);