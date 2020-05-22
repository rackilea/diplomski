final URL url = new URL("https://maps.googleapis.com/maps/api/geocode/json?address=Greenwich");
// Let Gson parse the JSON input stream without expensive intermediate strings
try ( final Reader reader = new BufferedReader(new InputStreamReader(url.openStream())) ) {
    final JsonParser jsonParser = new JsonParser();
    // Extract the `results` array
    final JsonArray resultsJsonArray = jsonParser.parse(reader)
            .getAsJsonObject()
            .get("results")
            .getAsJsonArray();
    // Iterate over each result array element
    for ( int i = 0; i < resultsJsonArray.size(); i++ ) {
        final JsonObject resultJsonObject = resultsJsonArray.get(i).getAsJsonObject();
        System.out.println(resultJsonObject.getAsJsonPrimitive("formatted_address").getAsString());
        // Picking up the `geometry` property as a JSON object
        final JsonObject geometryJsonObject = resultJsonObject.get("geometry").getAsJsonObject();
        // And dumping the location
        final JsonObject locationJsonObject = geometryJsonObject.get("location").getAsJsonObject();
        dumpLocationJsonObject("Location", locationJsonObject);
        final JsonElement boundsJsonElement = geometryJsonObject.get("bounds");
        // There can be a `bounds` object with two additional properties
        if ( boundsJsonElement != null && !boundsJsonElement.isJsonNull() ) {
            final JsonObject boundsJsonObject = boundsJsonElement.getAsJsonObject();
            dumpLocationJsonObject("North/East", boundsJsonObject.get("northeast").getAsJsonObject());
            dumpLocationJsonObject("South/West", boundsJsonObject.get("southwest").getAsJsonObject());
        }
    }
}