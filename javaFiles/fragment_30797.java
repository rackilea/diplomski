// {"pre-date":{"enable":true,"days":"3","interval":"1","mail-template":"582"},"on-date":{"enabled":false},"post-date":{"enabled":false}}
String json = "{\"pre-date\":{\"enable\":true,\"days\":\"3\",\"interval\":\"1\",\"mail-template\":\"582\"},\"on-date\":{\"enabled\":false},\"post-date\":{\"enabled\":false}}";

ObjectMapper mapper = new ObjectMapper();

// To put all of the JSON in a Map<String, Object>
Map<String, Object> map = mapper.readValue(json, Map.class);

// Accessing the three target data elements
Map<String, Object> preDateMap = (Map) map.get("pre-date");
System.out.println(preDateMap.get("enable"));
System.out.println(preDateMap.get("days"));
System.out.println(preDateMap.get("interval"));