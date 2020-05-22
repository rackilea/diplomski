public static void main(String[] args) {

    String data = "{\"emotional distress\":4,\"peer difficulties\":6,\"behavioural difficulties\":8,\"kind and helpful behaviour\":8,\"overall stress\":32,\"_sdqID\":11,\"hyperactivity and concentration\":6}";

    JSONObject json = new JSONObject();
    JSONArray chart = new JSONArray();
    json.put("chart", chart);
    JSONObject jsonObject = new JSONObject(data);
    Iterator<String> iterator = jsonObject.keys();
    while(iterator.hasNext()) {
        String key = iterator.next();
        if(key.equalsIgnoreCase("_sdqID")) {
            continue;
        }
        int value = jsonObject.getInt(key);
        key = key.toUpperCase();
        JSONObject row = new JSONObject();
        row.put("label", key);
        row.put("value", value);
        chart.put(row);
    }
}