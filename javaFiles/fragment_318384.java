for (int i = 0; i < data.length(); i++) {
    JSONObject dataItem = data.getJSONObject(i);
    JSONArray recordValues = dataItem.getJSONArray("Record");

    Map<String, String> record = new HashMap<>();

    for (int j = 0; j < keys.length(); j++) {
        String key = keys.getString(j);
        String value = recordValues.getString(j);
        record.put(key, value);
    }

    records.add(record);
}