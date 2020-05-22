try {
jsonarray = new JSONArray(result);
for (int i = 0; i < jsonarray.length(); i++) {
    jsonarrayInner = jsonarray.getJSONArray(i);
    //you can do one more loop here
    for (int i = 0; i < jsonarrayInner.length(); i++) {
        jsonobject = jsonarrayInner.getJSONObject(i);
        Log.e("testt", jsonobject.toString());
    }
    ...
    ...
}
}catch....