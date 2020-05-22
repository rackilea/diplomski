public class CustomSerializer implements JsonDeserializer<Rule> {
    public Rule deserialize(JsonElement jsonElement, Type type,
                             JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        JsonObject obj = (JsonObject) jsonElement;
        JsonElement value = obj.get("value");
        List<String> values = new ArrayList();
        if (value.isJsonArray()) {

            for (JsonElement jsonElement1 : value.getAsJsonArray()) {
                String str = jsonElement1.getAsString();
                values.add(str);
            }
        } else {
            values.add(value.getAsString());
        }
        // deserialize other properties


        Rule rule = new Rule();
        rule.setValue(values);
        // set other properties
        return rule;
    }
}