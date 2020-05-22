String jsonStr = "...";
ObjectReader reader = new ObjectMapper().reader();
List<Map<String, Object>> objs = reader.readValue(jsonStr);

Map<String, Object> myFirstObj = objs.get(0);
myFirstObj.get("data");
myFirstObj.get("what");
// and so on