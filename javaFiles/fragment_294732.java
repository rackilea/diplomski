public JSONObject createGroupInServer(
        Activity activity, String lastSyncDateTime,
        ArrayList<ContactGroup> groups)
        throws JSONException {

    JSONObject jResult = new JSONObject();
    jResult.putOpt("last_sync_date", lastSyncDateTime);

    JSONArray jArray = new JSONArray();

    for (int i = 0; i < groups.size(); i++) {
        JSONObject jGroup = new JSONObject();
        jGroup.put("guid", groups.get(i).getGroupId());
        jGroup.put("name", groups.get(i).getGroupName());
        jGroup.put("isDeleted", groups.get(i).getIsDeleted());
        // etcetera

        JSONObject jOuter = new JSONObject();
        jOuter.put("contact_group", jGroup);

        jArray.put(jOuter);
    }

    jResult.put("recordset", jArray);
    return jResult;
}