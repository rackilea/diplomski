ObjectMapper mapper = new ObjectMapper();
String jsonInput = "{\"1222\": [\"Joe\", 26, 158],\"1232\": [\"root\", 29, 168] }";
TypeReference<Map<String, EmployeeAttribute>> typeRef =
    new TypeReference<Map<String, EmployeeAttribute>>()
    {
    };

Map<String, EmployeeAttribute> map = mapper.readValue(jsonInput, typeRef);
map.values().iterator().forEachRemaining(System.out::println);