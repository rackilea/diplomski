public class ValueTypeAdapter extends TypeAdapter<Value> {

    @Override
    public Value read(JsonReader in) throws IOException {
        Value value = null;

        JsonParser jsonParser = new JsonParser();
        JsonElement je = jsonParser.parse(in);

        if(je instanceof JsonPrimitive) {   
            value = new Value();
            value.nameArr = new String[1];
            value.nameArr[0] = ((JsonPrimitive)je).getAsString();
        } else if (je instanceof JsonArray) {
            JsonArray jsonArr = (JsonArray)je;
            value = new Value();
            value.nameArr = new String[jsonArr.size()];
            for (int i = 0; i < jsonArr.size(); i++) {
                JsonObject jo = (JsonObject)jsonArr.get(i); 
                value.nameArr[i] = jo.get("name").getAsString();
            }
        }

        return value;
    }

    @Override
    public void write(JsonWriter out, Value value) throws IOException {
        if (value != null) {
            if (value.nameArr != null && value.nameArr.length > 0) {
                if (value.nameArr.length == 1) {
                    out.value(value.nameArr[0]);
                } else if (value.nameArr.length > 1) {
                    out.beginArray();
                    for (String nameVal : value.nameArr) {
                        out.beginObject();
                        out.name("name").value(nameVal);
                        out.endObject();
                    }
                    out.endArray();
                }
            }
        }
    }       
}