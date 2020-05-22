Data data = new Data();
data.setName("Tom");

Root root = new Root();
root.setData(data);

ObjectMapper mapperWithMixIn = new ObjectMapper();
mapperWithMixIn.addMixInAnnotations(Root.class, RootMixIn.class);

ObjectMapper mapperDefault = new ObjectMapper();

System.out.println("With MIX-IN");
System.out.println(mapperWithMixIn.writeValueAsString(root));

System.out.println("Default");
System.out.println(mapperDefault.writeValueAsString(root));