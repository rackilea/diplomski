try {
    JSONArray array = new JSONArray(jsonString);
    String[] servers = new String[array.length()];
    Integer[] itemsId = new Integer[array.length()];
    for (int i = 0; i < array.length(); i++) {
        JSONObject o = array.getJSONObject(i);
        servers[i] = o.getString("label");
        itemsId[i] = o.getInt("srvid");
    }

    //REST OF THE CODES
} catch (JSONException e) {
    e.printStackTrace();
} catch(Exception e) {
    e.printStackTrace();
}