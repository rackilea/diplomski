Foo foo = new Foo(11, Arrays.asList("a", "b", "c"));
ObjectMapper mapper = new ObjectMapper();

String json = mapper.writeValueAsString(foo);
System.out.println("Serialize to JSON:");
System.out.println(json);
System.out.println("Deserialize to POJO:");
System.out.println(mapper.readValue(json, Foo.class));