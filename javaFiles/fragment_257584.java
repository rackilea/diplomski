public static void getColor(JSONObject payloadObject) {
    try {
        JSONArray keys = payloadObject.names();
        for (int i = 0; i < keys.length(); i++) {
            String key = keys.getString(i); // Here's your key
            JSONObject value = payloadObject.getJSONObject(key); // Here's your value - nested JSON object
            String color = value.getString("color");
            System.out.println(color);
        }

    } catch (JSONException e) {
        e.printStackTrace();
    }
}