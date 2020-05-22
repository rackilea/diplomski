try {
    JSONArray response=new JSONArray(jsonstring);
    for (int i = 0; i < response.length(); i++) {
        JSONObject data=response.getJSONObject(i);
        String name=data.getString("Name");
        String values=data.getString("Values");
        //perform operation on name and values
    }
} catch (JSONException e1) {
    // TODO Auto-generated catch block
    e1.printStackTrace();
}