private void processJson(JSONObject object) {
    try {
        List<ServiceGroup> groups = new ArrayList<>();
        ServiceGroup currentGroup = null;

        JSONArray rows = object.getJSONArray("rows");

        for (int r = 0; r < rows.length(); ++r) {
            JSONObject row = rows.getJSONObject(r);
            JSONArray columns = row.getJSONArray("c");

            String name = columns.getJSONObject(0).getString("v");
            JSONObject priceColumn = columns.getJSONObject(1);

            if (priceColumn.isNull("v")) {
                currentGroup = new ServiceGroup(name);
                groups.add(currentGroup);
            }
            else {
                String price = priceColumn.getString("v");
                Service service = new Service(name, price);
                currentGroup.getServices().add(service);
            }
        }

        ...
    }
    catch (JSONException e) {
        ...
    }
}