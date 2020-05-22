private JSONObject getJsonObject(String url) {
    HttpResponse<JsonNode> response;

    try {
        response = Unirest.get(url).asJson();
    } catch (UnirestException e) {
        Logger.error("Failed to GET data. Connection string was: " + url);
        return null;
    }
    return response.getBody().getObject();
}