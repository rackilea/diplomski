List<String> allNames = new ArrayList<String>();

JSONArray cast = jsonResponse.getJSONArray("abridged_cast");
for (int i=0; i<cast.length(); i++) {
    JSONObject actor = cast.getJSONObject(i);
    String name = actor.getString("name");
    allNames.add(name);
}