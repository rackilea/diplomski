JSONParser parser = new JSONParser();
try {
    Object object = parser.parse(jsonString);
    JSONArray array = (JSONArray) object;

    JSONArray meta = (JSONArray) array.get("meta");
    JSONObject jsonObject = (JSONObject) meta.get("code");
} catch (ParseException e) {
    e.printStackTrace();
}