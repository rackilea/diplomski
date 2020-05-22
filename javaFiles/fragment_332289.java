JsonParser parser = new JsonParser();
JsonObject rootObj = parser.parse(json).getAsJsonObject();
JsonObject locObj = rootObj.getAsJsonObject("result")
    .getAsJsonObject("geometry").getAsJsonObject("location");

String status = rootObj.get("status").getAsString();
String lat = locObj.get("lat").getAsString();
String lng = locObj.get("lng").getAsString();

System.out.printf("Status: %s, Latitude: %s, Longitude: %s\n", status,
        lat, lng);