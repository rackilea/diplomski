try {
    JSONArray jsonArray=new JSONArray(ResultHolder);
    for(int i=0;i<jsonArray.length();i++){
        JSONObject jsonObject=jsonArray.getJSONObject(i);
        listString.add(jsonObject.getString("name")) ;
    }
} catch (JSONException e) {
    e.printStackTrace();
}