JSONObject jsonObject = jsonArray.getJSONObject(0);
String KK_ID = jsonObject.getString("KK_ID");
String MONTH = jsonObject.getString("MONTH");

JSONArray innerJsonArray = jsonObject.getJSONArray("MY_UNIT");

String[][] strAry = new String[innerJsonArray.length()][2];

for (int i = 0; i < innerJsonArray.length(); i++) {
     JSONObject innerJsonobject = innerJsonArray.getJSONObject(i);
     strAry[i][0] = innerJsonobject.getString("dataid");
     strAry[i][1] = innerJsonobject.getString("unit");
 }