public static void main(String[] args) throws Exception {
    final String personal
            = "{"
            + "  \"personal\": {"
            + "    \"name\": \"John Doe\","
            + "    \"age\": \"28\","
            + "    \"gender\": \"male\""
            + "  }"
            + "}";
    final String address 
            = "{"
            + "  \"address\": {"
            + "    \"street\": \"123 main st\","
            + "    \"state\": \"md\","
            + "    \"zipcode\": \"21228\""
            + "  }"
            + "}";

    ObjectMapper mapper = new ObjectMapper();
    SimpleModule module = new SimpleModule();
    module.addDeserializer(
            CustomerInfo.class, 
            new CustomerInfoDeserializer("personal", "address")
    );
    module.addSerializer(CustomerInfo.class, new CustomerInfoSerializer());
    mapper.registerModule(module);

    CustomerInfo info = mapper.readValue(personal, CustomerInfo.class);
    System.out.println(mapper.writeValueAsString(info));

    info = mapper.readValue(address, CustomerInfo.class);
    System.out.println(mapper.writeValueAsString(info));
}