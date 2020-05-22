public class WayPointsDeserializer extends JsonDeserializer<List<WayPoints>> {

    @Override
    public List<WayPoints> deserialize(JsonParser jsonParser, DeserializationContext ctxt) 
      throws IOException, JsonProcessingException {
        List<WayPoints> wayPoints = new ArrayList<>();
        if (jsonParser.getCurrentToken() == JsonToken.START_ARRAY) {
            while(jsonParser.nextToken() != JsonToken.END_ARRAY) {
                WayPoints wp = new WayPoints();
                jsonParser.nextToken();
                wp.setLat(jsonParser.getDoubleValue());
                jsonParser.nextToken();
                wp.setLng(jsonParser.getDoubleValue());
                wayPoints.add(wp);
                jsonParser.nextToken();
            }
            return wayPoints;
        }
        throw ctxt.mappingException("Expect '['");
    }
}