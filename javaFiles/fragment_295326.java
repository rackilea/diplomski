try {
    JSONObject json = new JSONObject(readUrl("http://dbpedia.org/data3/assembly.json"));
    ...

} catch (JSONException e) {
    e.printStackTrace();
}