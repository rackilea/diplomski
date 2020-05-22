public static void main(String... args) throws Exception {
    String testJson = "[{ \"1234\" : { \"name\" : \"dan\" } },{ \"5678\" : { \"name\" : \"mike\" } }]";

    ObjectMapper mapper = new ObjectMapper();
    SimpleModule module = new SimpleModule();
    module.addDeserializer(NameId.class, new MyDeserializer());
    mapper.registerModule(module);
    ArrayList<NameId> map = mapper.readValue(testJson.getBytes(), new TypeReference<List<NameId>>() {
    });
    for (NameId m : map) {
        System.out.println(m.id);
        System.out.println(m.name.name);
        System.out.println("----");
    }
}


@JsonDeserialize(contentUsing = MyDeserializer.class)
static class NameId {
     String id;
     Name name;
     //getter and setters
    }

static class Name {
     String name;
     //getter and setter
}

static class MyDeserializer extends JsonDeserializer<NameId> {

    @Override
    public NameId deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = p.getCodec().readTree(p);
        Map.Entry<String, JsonNode> nodeData = node.fields().next();
        String id = nodeData.getKey();
        String name = nodeData.getValue().get("name").asText();
        Name nameObj = new Name();
        nameObj.name = name;
        NameId nameIdObj = new NameId();
        nameIdObj.name = nameObj;
        nameIdObj.id = id;
        return nameIdObj;
    }
}