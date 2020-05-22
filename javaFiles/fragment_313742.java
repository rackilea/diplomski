public class PageJsonDeserializer implements JsonDeserializer<PageJson> {

   @Override
    public PageJson deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

         final JsonObject pageJsonObj = json.getAsJsonObject();
         String page = pageJsonObj.get("page").getAsString();
         JsonObject results = pageJsonObj.get("results").getAsJsonObject();

         //TODO: Decide here according to page which object to construct for results
         //and then call the constructor of PageJson

         //return constructed PageJson instance
    }        
}