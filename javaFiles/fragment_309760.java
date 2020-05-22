JSONObject object = new JSONObject(s);
JSONArray valueArr = object.getJSONArray("Value");
String result =String.valueOf(valueArr.get(0));
//you'll get :  14.1"

result = result.replace("\"","")
// final: 14.1