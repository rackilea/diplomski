JSONObject json = new JSONObject(builder.toString());
//Add this line 
JSONObject responseData = json.getJSONObject("responseData");
final JSONArray geodata = responseData.getJSONArray("results");
final int n = geodata.length();

for (int i = 0; i < n; ++i) {
    final JSONObject person = geodata.getJSONObject(i);
    System.out.println(person.geString("width"));
}