String json = ... // Your JSON with the above correction
ObjectMapper objectMapper = new ObjectMapper();
List<Container> containers = objectMapper.readValue(json, new TypeReference<List<Container>>() {});
System.out.println(containers.size());
for(Container container : containers) {
    System.out.println("Container Id : " + container.getId());
}