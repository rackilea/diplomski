try {
    jsonParams.put("group_id", "dlfsdds");

    JSONArray listJson = new JSONArray();

    for(int i=0; i<list.size(); i++) {
        listJson.put(list.get(i));
    }


    jsonParams.put("users", listJson);

} catch (JSONException e) {
  e.printStackTrace();
}