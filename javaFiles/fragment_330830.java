JSONObject object = new JSONObject();
object.put("id", 12345);
object.put("name", "Name");
JSONObject status = new JSONObject();
object.put("status", status);
status.put("yes", new JSONArray(Arrays.asList("N1", "n2", "n3")));
status.put("no", new JSONArray(Arrays.asList("n1", "n2", "n3")));

JSONArray array = new JSONArray(Collections.singletonList(object));
System.out.println(array);