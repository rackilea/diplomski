//GSON config
Gson gson = new GsonBuilder()
            .registerTypeAdapter(DateTime.class, new DateTimeDeserializer ())
            .create();


// DateTimeDeserializer.class
    public class DateTimeDeserializer implements JsonDeserializer<DateTime > {

      @Override
      public DateTime deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
          throws JsonParseException {
        return DateTime.parse(json.getAsString());
      }
    }