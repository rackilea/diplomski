public void add(String propertyName, String[] values){

    JsonArray array = new JsonArray();
    for(int i = 0; i < values.length; i++){
        array.add(values[i]);
    }

    JsonObject json = new JsonObject();
    json.addProperty("propName", propertyName);
    json.add("value" ,array);
}