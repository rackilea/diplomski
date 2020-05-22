JSONArray json = new JSONArray(jsonString);
for(int index = 0; index < json.length(); index++) {
    JSONObject jsonObject = json.getJSONObject(index);
    String name = jsonObject.getString("name");
    String number = jsonObject.getString("number");
    System.out.println("name: " + name + " number: " + number);
}