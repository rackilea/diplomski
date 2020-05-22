JSONArray jsonArray = new JSONArray();

JSONObject oneMonth = new JSONObject();

try {
    oneMonth.put("duration", "1");
    oneMonth.put("price", "100");

} catch (JSONException e) {
    e.printStackTrace();
}

JSONObject threeMonth = new JSONObject();
try {
    threeMonth.put("duration", "2");
    threeMonth.put("price", "200");

} catch (JSONException e) {
    e.printStackTrace();
}

JSONObject sixMonth = new JSONObject();
try {
    sixMonth.put("duration", "3");
    sixMonth.put("price", "300");

} catch (JSONException e) {
    e.printStackTrace();
}

JSONObject twelveMonth = new JSONObject();
try {
    twelveMonth.put("duration", "4");
    twelveMonth.put("price", "400");
      } catch (JSONException e) {
    e.printStackTrace();
}

try {
     jsonArray.put(oneMonth);
     jsonArray.put(threeMonth);
     jsonArray.put(sixMonth);
     jsonArray.put(twelveMonth);
} catch (JSONException e) {
    e.printStackTrace();
}