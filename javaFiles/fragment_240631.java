private JSONArray getTable(JSONObject json) throws JSONException {
    JSONArray table = (JSONArray) json.getJSONObject("context")
            .getJSONObject("dispatcher")
            .getJSONObject("stores")
            .getJSONObject("QuoteSummaryStore")
            .getJSONObject("incomeStatementHistoryQuarterly")
            .getJSONArray("incomeStatementHistory");
    return table;
}

private String[] getRow(JSONArray table, String name) throws JSONException {
    String[] values = new String[table.length()];
    for (int i = 0; i < table.length(); i++) {
        JSONObject jo = table.getJSONObject(i);
        if (jo.has(name)) {
            jo = jo.getJSONObject(name);
            values[i] = jo.has("longFmt") ? jo.get("longFmt").toString() : "-";
        } else {
            values[i] = "-";
        }
    }
    return values;
}

private String[] getDates(JSONArray table) throws JSONException {
    String[] values = new String[table.length()];
    for (int i = 0; i < table.length(); i++) {
        values[i] = table.getJSONObject(i).getJSONObject("endDate")
                .get("fmt").toString();
    }
    return values;
}