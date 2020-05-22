ObjectMapper mapper = new ObjectMapper();
JsonNode root = mapper.readTree(json);
Map<String, String> map = new HashMap<>();
addKeys("", root, map, new ArrayList<>());

map.entrySet()
     .forEach(System.out::println);