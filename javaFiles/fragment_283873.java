try {
    JSONArray jsonArray = jsonResponse.getJSONArray("LatestData");
    if (jsonArray != null && jsonArray.length() > 0) {
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject dataOjbect = jsonArray.getJSONObject(i);
            String url = dataOjbect.getString("url");
        }
    }
} catch (Exception e) {
    e.printStackTrace();
}