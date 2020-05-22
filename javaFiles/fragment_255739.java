Map<String, String> data = Collections.singletonMap("person", "{\"name\": \"nick\", \"age\": 18}");

ObjectMapper mapper = new ObjectMapper();
Map<String, Object> dataTree = new HashMap<>();
for (Entry<String, String> entry : data.entrySet())
    dataTree.put(entry.getKey(), mapper.readTree(entry.getValue()));
Info info = mapper.convertValue(dataTree, Info.class);

System.out.println("name = " + info.getPerson().getName());
System.out.println("age = " + info.getPerson().getAge());