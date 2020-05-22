final Gson builder = new GsonBuilder()
    .registerTypeAdapter(Date.class, new JsonDeserializer<Date>() { 
       public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
          return new Date(jsonElement.getAsJsonPrimitive().getAsLong()); 
       } 
    })
    .create();