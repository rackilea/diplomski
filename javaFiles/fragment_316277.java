JSONArray jArray;
JSONObject jobj = new JSONObject(); // if you need it
String result = sendHttpRequest("www.yourUrl.com");
// Parse the string to get a json array
try {
    jArray = new JSONArray(result);
    jobj = jArray.getJSONObject(0); // 0 is the index in the json array...
} catch (JSONException e) {
}