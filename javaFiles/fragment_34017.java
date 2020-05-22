@RunWith(MockitoJUnitRunner.class)
public class ResourceDeserializerTest {

    @Mock private JsonDeserializationContext mockContext;

    private Gson gson;

    @Before
    public void setUp() {
        gson = new GsonBuilder()
                .registerTypeAdapter(ResourceMap.class, new ResourceMapDeserializer())
                .setPrettyPrinting()
                .create();
    }

    @Test
    public void deserializes_resource_map() {
        final JsonObject woodJson = new JsonObject();
        woodJson.addProperty("quantity", 4);

        final JsonObject stoneJson = new JsonObject();
        stoneJson.addProperty("quantity", 2);

        final JsonObject mapJson = new JsonObject();
        mapJson.add("Wood", woodJson);
        mapJson.add("Stone", stoneJson);

        final ResourceMap deserialized = gson.fromJson(mapJson, ResourceMap.class);

        assertThat(deserialized.resources.get("Wood").getClass()).isEqualTo(Wood.class);

        assertThat(deserialized.resources.get("Stone").getClass()).isEqualTo(Stone.class);
    }

}