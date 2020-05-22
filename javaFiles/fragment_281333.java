Map<String, Object> data = json.parseJSON(new InputStreamReader(
    new ByteArrayInputStream(r.getResponseData()), "UTF-8"));

List<Map<String, Object>> content = (java.util.List<Map<String, Object>>)data.get("root");

for(Map<String, Object> obj : content) {
    Log.p(obj.getValue().toString());
}