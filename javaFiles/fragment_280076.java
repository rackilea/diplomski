public class StationDeserializer implements JsonDeserializer<Station> {

    private final Gson gson = new Gson();

    @Override
    public Station deserialize(JsonElement json, Type typeOfT
                ,JsonDeserializationContext context)
        throws JsonParseException {         
        try {
            return gson.fromJson(json, Station.class);
        } catch (JsonSyntaxException e) {
            // it was not a Station object
            Station station = new Station();
            // so try to set the error string
            station.error = json.getAsString();
            return station;
        }
    }

}