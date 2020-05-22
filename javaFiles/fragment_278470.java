String jsonString = yourstring;
JSONObject jsonResult = new JSONObject(jsonString);
JSONArray data = jsonResult.getJSONArray("data");
if(data != null) {
    String[] names = new String[data.length()];
    String[] birthdays = new String[data.length()];
    for(int i = 0 ; i < data.length() ; i++) {
        birthdays[i] = data.getString("birthday");
        names[i] = data.getString("name");
    }
}