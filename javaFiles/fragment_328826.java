String json = "{\n" +
    "    \"name\": \"Toyota Civic 3 days sale!!\",\n" +
    "    \"type\": \"coke\"," +
    "    \"pictures\": [\n" +
    "      {\n" +
    "        \"name\": \"picture 1\"\n" +
    "      },\n" +
    "      {\n" +
    "        \"name\": \"picture 2\"\n" +
    "      }\n" +
    "    ],\n" +
    "    \"cokeProperty\": \"sweet\",\n" +
    "    \"cokeProperty2\": \"not healthy\"\n" +
    "}";

ObjectMapper mapper = new ObjectMapper();

Item item = mapper.readValue(json, Item.class);

System.out.println(item);

// outputs:
// Coke(super=Item(id=0, name=Toyota Civic 3 days sale!!, pictures=[Picture(id=0, name=picture 2), Picture(id=0, name=picture 1)]), cokeProperty=sweet, cokeProperty2=not healthy)