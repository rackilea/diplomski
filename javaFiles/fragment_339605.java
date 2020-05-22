public class CustomDeserializer implements JsonDeserializer<Data> {

    @Override
    public Data deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context) throws JsonParseException {
        final JsonObject jsonObject = json.getAsJsonObject();

        final int this_number = jsonObject.get("this_number").getAsInt();
        final int that_number = jsonObject.get("that_number").getAsInt();
        final String some_string = jsonObject.get("some_string").getAsString();

        JsonObject list_of_objects =jsonObject.get("list_of_objects").getAsJsonObject();

        Set<Entry<String, JsonElement>> objects =  list_of_objects.entrySet();

        final Data data = new Data();
        List<DataInfo> list = new ArrayList<>();

        Gson gson = new Gson();

        for (Entry<String, JsonElement> entry : objects) {
            JsonElement jsonElement  = entry.getValue();
            DataInfo info = gson.fromJson(jsonElement,DataInfo.class);
            list.add(info);
        }

        data.setObjects(list);
        data.setSome_string(some_string);
        data.setThat_number(that_number);
        data.setThis_number(this_number);

        return data;
    }
}