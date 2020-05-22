// String 's' holds the JSON 

JsonParser jsonParser = new JsonParser();
JsonArray jsonArray = (JsonArray) jsonParser.parse(s);

// this object is used to get the keys
JsonObject firstJsonObject = jsonArray.get(0).getAsJsonObject();        
Set<java.util.Map.Entry<String, JsonElement>> entrySet = firstJsonObject.entrySet();

// declare two dimensional array
Object[][] array = new Object[entrySet.size()][jsonArray.size() + 1];

// the first column of the two-dimensional array is populated
Iterator<java.util.Map.Entry<String, JsonElement>> itr = entrySet.iterator();
for (int i = 0; itr.hasNext(); i++) {
    array[i][0] = itr.next().getKey();
}

// the rest of the columns are populated
for (int i = 0; i < jsonArray.size(); i++) {
    JsonObject obj = (JsonObject) jsonArray.get(i);
    for (int j = 0; j < array.length; j++) {
        String key = array[j][0].toString();
        JsonElement value = obj.get(key);
        array[j][i + 1] = value instanceof JsonNull ? null : value.getAsString();
    }

}
// now the two dimensional array is fully populated