JSONArray array;
for(int i = 0; i < array.length(); i++){
    JSONObject json = array.getJSONObject(i);

    if (json.has("errors")){
        //magic
    }
}