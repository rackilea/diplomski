public class RouteResponseTypeAdapter extends TypeAdapter<RouteResponse> {

    private final TypeAdapter<JsonElement> jsonElementTypeAdapter;
    private final TypeAdapter<Distance> distanceTypeAdapter;

    public RouteResponseTypeAdapter(Gson gson) {
        this.jsonElementTypeAdapter = gson.getAdapter(JsonElement.class);
        this.distanceTypeAdapter = gson.getAdapter(Distance.class);
    }

    @Override
    public void write(JsonWriter out, RouteResponse value) throws IOException {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public RouteResponse read(JsonReader jsonReader) throws IOException {
        RouteResponse result = new RouteResponse();
        List<Distance> distances = new ArrayList<>();
        result.setDistances(distances);
        if (jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
            JsonObject responseObject = (JsonObject) jsonElementTypeAdapter.read(jsonReader);
            JsonArray routes = responseObject.getAsJsonArray("routes");
            if (routes != null) {
                for (JsonElement element:routes) {
                    JsonObject route = element.getAsJsonObject();
                    JsonArray legs = route.getAsJsonArray("legs");
                    if (legs != null) {
                        for (JsonElement legElement:legs) {
                            JsonObject leg = legElement.getAsJsonObject();
                            JsonElement distanceElement = leg.get("distance");
                            if (distanceElement != null) {
                                distances.add(distanceTypeAdapter.fromJsonTree(distanceElement));
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}