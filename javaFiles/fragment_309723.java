JSONObject json = new JSONObject();
json.put("set", new HashSet<>(Arrays.asList("a", "b")));
json.put("list", Arrays.asList("a", "b"));
String jsonString = json.toString();

System.out.println(jsonString);

JSONObject afterParse = new JSONObject(jsonString);
System.out.println(afterParse.toString());