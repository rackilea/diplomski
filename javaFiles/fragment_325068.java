private void processJson(JSONObject object) {
    try {
        JSONArray rows = object.getJSONArray("rows");

        for (int r = 0; r < rows.length(); ++r) {
            JSONObject row = rows.getJSONObject(r);
            JSONArray columns = row.getJSONArray("c");

            String name = columns.getJSONObject(0).getString("v");
            names.add(name);
        }
        adapterBusinessType.notifyDataSetChanged();
    } catch (JSONException e) {
        e.printStackTrace();
    }
}