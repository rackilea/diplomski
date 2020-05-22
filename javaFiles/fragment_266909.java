class LanguagesTypeAdapter implements JsonSerializer<Languages>, JsonDeserializer<Languages>
{
      public JsonElement serialize(Languages languages, Type typeOfT, JsonSerializationContext context)
      {
          JsonObject json = new JsonObject();

          for (Language language : languages.list)
          {
              json.addProperty(language.name, language.loc);
          }

          return json;
      }

      public Languages deserialize(JsonElement element, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
      {
          JsonObject json = element.getAsJsonObject();

          Languages languages = new Languages();

          for (Entry<String, JsonElement> entry : json.entrySet())
          {
              String name = entry.getKey();
              Integer loc = entry.getValue().getAsInt();

              Language language = new Language();
              language.name = name;
              language.loc = loc;

              languages.list.add(language); 
          }

          return languages;
      }
}