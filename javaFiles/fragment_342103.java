try(JsonReader reader = new JsonReader(new InputStreamReader(
    new FileInputStream(filename))))
{
  JsonParser jsonParser = new JsonParser();
  return jsonParser.parse(reader).getAsJsonObject();
}