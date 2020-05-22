String json1 = "{\"title\":[\"1\",\"2\"], \"amount\":[\"1\",\"2\"]}";
String json2 = "{\"title\":\"\", \"amount\":\"\"}";

Gson gson = new Gson();
HashMap map = gson.fromJson(json1, HashMap.class);
HashMap map2 = gson.fromJson(json2, HashMap.class);

System.out.println(map);
System.out.println(map2);

System.out.println(map.get("amount").getClass());
System.out.println(map2.get("amount").getClass());