try{
    // Convert JSON-string to a List of Order objects
    Type listType = new TypeToken<ArrayList<Order>>(){}.getType();
    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
        @Override
        public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            try{
                return df.parse(json.getAsString());
            }
            catch(ParseException ex){
                return null;
            }
        }
    });
    Gson dateGson = gsonBuilder.create();
    orders = dateGson.fromJson(json, listType);
}
catch(JsonParseException ex){
    ex.printStackTrace();
}