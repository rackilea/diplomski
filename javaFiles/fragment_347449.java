Iterator mainKeys = resultJson.keys();
while (mainKeys.hasNext()) {
    String key = (String) mainKeys.next();
    JSONArray array = resultJson.getJSONArray(key);

    for (int index = 0; index < array.length(); index++) {
        JSONObject object = array.getJSONObject(index);
        if (object.has("accountId")) {
            String accountId = object.get("accountId").toString();
            JSONObject accum = accountIds
                    .computeIfAbsent(accountId, (k) -> new JSONObject());

            // depending on the json impl you can use putAll or similar
            Iterator objKeys = object.keys();
            while (objKeys.hasNext()) {
                String property = (String) objKeys.next();
                accum.put(property, object.get(property));
            }

        } else {
            // does not have account id, ignore or throw
        }
    }
}