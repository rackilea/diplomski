JSONArray arrArrors = jObject.getJSONArray("errors");
//iterate to arrArrors get all values
for(int i=0;i<arrArrors.length;i++) {
  String error = arrArrors.optString(i);
  Log.i("JSONDATA","error :: "+error);
}