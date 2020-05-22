JSONObject jObj;
try {
  jObj = new JSONObject(jsonString);
  JSONArray jArr = jObj.getJSONArray("filelist");
  JSONObject jObj2 = jArr.getJSONObject(0);
  textView1.setText(jObj2.getString("filename"));
} catch (JSONException e) {
  e.printStackTrace();
}