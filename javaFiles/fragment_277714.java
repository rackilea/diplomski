public class JacksonInjectObjectMapper {

    private static final String JSON =
            "{\"field1\":\"{\\\"field0\\\":\\\"value0\\\"}\", " +
            "\"field2\":\"value2\"}";

    public static class Foo {
        public String field0;

        @Override
        public String toString() {
            return "Foo{" +
                    "field0='" + field0 + '\'' +
                    '}';
        }
    }

    public static class Bean {
        @JsonDeserialize(using = FooDeserializer.class)
        public Foo field1;
        public String field2;

        @Override
        public String toString() {
            return "Bean{" +
                    "field1=" + field1 +
                    ", field2='" + field2 + '\'' +
                    '}';
        }
    }

    public static class FooDeserializer extends JsonDeserializer<Foo> {

        @Override
        public Foo deserialize(
                final JsonParser jp, final DeserializationContext ctxt)
                throws IOException {
            final ObjectMapper mapper = (ObjectMapper) ctxt.findInjectableValue(
                    ObjectMapper.class.getName(),
                    null,
                    null);
            final String json = jp.getValueAsString();
            System.out.println(json);
            return mapper.readValue(json, Foo.class);
        }
    }

    public static void main(String[] args) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        final InjectableValues.Std injectableValues = new InjectableValues.Std();
        injectableValues.addValue(ObjectMapper.class, mapper);
        mapper.setInjectableValues(injectableValues);

        final Bean bean = mapper.readValue(JSON, Bean.class);
        System.out.println(bean);
    }
}