String jsonInput = "{\n" +
  "    \"keyA\": \"java.lang.Double\",\n" +
  "    \"keyB\": \"[Ljava.lang.Double;\",\n" +
  "    \"keyC\": \"java.lang.Double\"\n" +
  "    }";
TypeReference<HashMap<String, Class>> typeRef
  = new TypeReference<HashMap<String, Class>>() {};
ObjectMapper mapper = new ObjectMapper();
Map<String, Class> map = mapper.readValue(jsonInput, typeRef);
System.out.println(map);