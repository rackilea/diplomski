List data = new ArrayList();
ObjectMapper mapper = new ObjectMapper();

data.add("hello");
data.add(someobject);

String json = mapper.writeValueAsString(data);