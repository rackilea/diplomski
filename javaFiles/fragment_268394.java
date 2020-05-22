JSONArray jarr = information;

    for (int i = 0; i < allData.length(); i++ ) {
        final String uploadUrl = allData.getJSONObject(i).getString("content_url");
        final String previewUrl = allData.getJSONObject(i).getString("preview_url");

        JSONObject object = new jarr.getJSONObject(i);
        object.put("content", uploadUrl);
        object.put("preview", previewUrl);
        jarr.put(i, object);
    }