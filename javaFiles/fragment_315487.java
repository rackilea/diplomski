ObjectMapper mapper = new ObjectMapper();
  Map<String, Object> container = mapper.readValue(facebookDataJsonString, Map.class);
  List<Map<String,Object>> = container.get("data");
  for (Map<String,Object> map : container ) {
    System.out.println( "type is " + map.get("type"));
    System.out.println( "from is " + ((Map<String,Object>)map.get("from")).get("name"));
    System.out.println( "message is " + map.get("message"));
  }