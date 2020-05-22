Object obj = new JSONParser().parse(result); 
if (obj instanceof JSONObject) {
    JSONObject jo = (JSONObject) obj;
} else {
    JSONArray ja = (JSONArray) obj;
}