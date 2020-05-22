JsonParser jsParser = new JsonParser();
JsonObject jsObject = (JsonObject)jsParser.parse(jsonStr);
JsonObject property = jsObject.getAsJsonObject("property");
JsonObject tourist  = property.getAsJsonObject("/travel/travel_destination/tourist_attractions");
JsonArray  values   = tourist.getAsJsonArray("values"); 
for(int i=0;i<values.size();i++) {
    JsonObject data = values.get(i).getAsJsonObject();
    String text = data.get("text").getAsString();
}