JSONArray temp = jsonObject.getJSONArray("name");
int length = temp.length();
if (length > 0) {
    String [] recipients = new String [length];
    for (int i = 0; i < length; i++) {
        recipients[i] = temp.getString(i);
    }
}