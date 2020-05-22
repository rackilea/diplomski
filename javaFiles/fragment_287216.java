JSONArray jsonArray = new JSONArray(jsonArrayStr); // JSONArray is from the json.org library
String[][] arrayOfArrays = new String[jsonArray.length()][];
for (int i = 0; i < jsonArray.length(); i++) {
    JSONArray innerJsonArray = (JSONArray) jsonArray.get(i);
    String[] stringArray = new String[innerJsonArray.length()];
    for (int j = 0; j < innerJsonArray.length(); j++) {
        stringArray[j] = innerJsonArray.get(j);
    }
    arrayOfArrays[i] = stringArray;
}