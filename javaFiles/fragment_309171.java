private ObjectMapper mapper;

@Before
public void setupObjectMapper() {
    mapper = new ObjectMapper();
    mapper.setNodeFactory(new JsonNodeFactory() {
        @Override
        public TextNode textNode(String text) {
            return super.textNode(text.toUpperCase());
        }
    });
}

@Test
public void printJson() throws IOException {
    Entity myEntity = new Entity("myName");
    mapper.writeValue(System.out, myEntity); // prints: {"name":"myName"}
}

@Test
public void valuesAreUpperCasedWhenLoaded() throws IOException {
    JsonNode jsonNode = mapper.readTree("{\"name\":\"myName\"}");
    Entity myEntity = mapper.treeToValue(jsonNode, Entity.class);
    assertThat(myEntity.getName()).isEqualTo("MYNAME");
}

public static class Entity {
    private final String name;

    @JsonCreator
    public Entity(@JsonProperty("name") String name) { this.name = name; }

    public String getName() { return name; }

    @Override
    public String toString() { return "name='" + name + "'"; }
}