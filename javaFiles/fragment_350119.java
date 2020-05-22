JsonArray data = jsonObject.getJsonArray("data");

int count = data.size();
for (int i = 0; i < count; i++) {
    String complexValuesStr = data.getString(i);
    // ...
}