ObjectMapper mapper = new ObjectMapper();

// Convert POJO to Map
Map<String, Object> map = 
    mapper.convertValue(foo, new TypeReference<Map<String, Object>>() {});

// Convert Map to POJO
Foo anotherFoo = mapper.convertValue(map, Foo.class);