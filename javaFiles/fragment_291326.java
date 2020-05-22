JSONObject obj = new JSONObject(" .... ");
JSONArray arr = obj.getJSONArray("products");
for (int i = 0; i < arr.length(); i++) {
    String name = arr.getJSONObject(i).getString("name");
    if ( name.equals("20CN ADSL Max") ) {
        String s =  arr.getJSONObject(i).getString("likely down speed");
    }
}