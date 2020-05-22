JSONArray arrayStatus = line.getJSONArray("lineStatuses");
int len = arrayStatus.length();
    for (int j = 0; j < len; j++) {
        JSONObject o = arrayStatus.getJSONObject(j);
        String statusSeverityDescription = o.optString("statusSeverityDescription", "");
    }