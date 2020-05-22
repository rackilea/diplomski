final JSONArray root = new JSONArray(YOUR_JSON_STRING);

final JSONObject numData = root.getJSONObject(1);
final JSONArray numArray = numData.getJSONArray("56");

for (int i = 0; i < numArray.length(); ++i) {
  if (i == 1 || i == 11)
      System.out.print(numArray.getInt(i)+",");
  else
      System.out.print(numArray.getString(i)+",");
}
// prints: "81",3,"0","","","","","0","","4754","M",1,