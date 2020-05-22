A a = new A(101, "test");
List<Error> errors = Arrays.asList(new Error("id", "already in use"), new Error("value",
        "field to long"));

// Create Jackson objects
ObjectMapper jsonMapper = new ObjectMapper();
MapType mapType = jsonMapper.getTypeFactory().constructMapType(LinkedHashMap.class,
        String.class, Object.class);

// Create map
LinkedHashMap<String, Object> map = jsonMapper.convertValue(a, mapType);
map.put("__errors__", errors);

// Serialize map
String json = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);

System.out.println(json);