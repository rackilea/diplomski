JSONObject obj = (JSONObject) JSONSerializer.toJSON(jsonString);
JSONArray content = obj.getJSONObject("Demo").getJSONArray("CONTENT");

java.util.Iterator<?> iterator = content.iterator();
while (iterator.hasNext()) {
    JSONObject o = (JSONObject) iterator.next();
    System.out.println(o);
    System.out.println(o.get("ID"));
    // etc...
}