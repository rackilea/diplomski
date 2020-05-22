MapValue customerName = new MapValue();
customerName.put("customerName", new StringValue("customerValue"));

MapValue innerMap = new MapValue();
innerMap.put("anotherObj1", new StringValue("TEST"));
innerMap.put("anotherObj2", new DateValue("01/12/2018"));
innerMap.put("anotherObj3", new DateValue("31/01/2018"));

MapValue fourthObject = new MapValue();
fourthObject.put("firstObject", innerMap);

Root root = new Root();
root.firstObject = new StringValue("productValue");
root.secondObject = new StringValue("statusValue");
root.thirdObject = customerName;
root.fourthObject = fourthObject;

ObjectMapper mapper = new ObjectMapper();
String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
System.out.println(json);
System.out.println(mapper.readValue(json, Root.class));