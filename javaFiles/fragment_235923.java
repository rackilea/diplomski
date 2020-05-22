public void getPlaces(LatLong latLong, int redius, Collection<PlaceType> places, Handler<JsonObject> handler) {

    if(redius <= 0 || redius > 50000) {
        throw new IllegalAccessError("redis can be 0 to 50000 meters only");
    }

    String uri = String.format(GOOGLE_PLACE_API_URI, latLong.getLatitude(), latLong.getLongitude(), redius, PROJECT_API_KEY, Joiner.on("|").join(places));

    HttpClientRequest request = httpClient.getAbs(uri, response ->{
        logger.info("Received response with status code={} message={}", response.statusCode(), response.statusMessage());
        response.bodyHandler( buffer -> {
            JsonObject result = buffer.toJsonObject();
            String nextPageToken = result.getString("next_page_token");
            JsonArray resultArray = result.getJsonArray("results");
            System.out.println("nextPageToken="+nextPageToken+" result="+resultArray);
            handler.handle(result); // call the result handler
        });

    }).setTimeout(30000);

    request.exceptionHandler(e -> {
        logger.error("Caught exception while making request for google place APIs. Error message={} e=", e.getMessage(), e);
    });
    request.end();
}