public class VectorTest {

    private static final String JSON = "{\n" +
            "    \"type\": \"viper\",\n" +
            "    \"location\": [\n" +
            "        20,\n" +
            "        173,\n" +
            "        153\n" +
            "    ]\n" +
            "}";

    static {
        Configuration.setDefaults(new Configuration.Defaults() {
            private final JsonProvider jsonProvider = new JacksonJsonProvider();
            private final MappingProvider mappingProvider = new JacksonMappingProvider();
            private final Set<Option> options = EnumSet.noneOf(Option.class);

            public JsonProvider jsonProvider() {
                return jsonProvider;
            }

            @Override
            public MappingProvider mappingProvider() {
                return mappingProvider;
            }

            @Override
            public Set<Option> options() {
                return options;
            }
        });
    }

    public static final class Vector3d {
        public final int x, y, z;

        @JsonCreator
        public Vector3d(int[] values) {
            this.x = values[0];
            this.y = values[1];
            this.z = values[2];
        }
    }

    @Test
    public void a_test() {
        Vector3d vector = JsonPath.parse(JSON).read("$.location", Vector3d.class);

        Assert.assertThat(vector.x, is(20));
        Assert.assertThat(vector.y, is(173));
        Assert.assertThat(vector.z, is(153));
    }
}