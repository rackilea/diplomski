public class JacksonPair {
    static final String JSON = "{ \"x\" : 1,  \n" +
            "  \"y\" : 2, \n" +
            "  \"the_list\" : [[1,2],[3,4]]}";

    static class Demo {
        public int x;
        public int y;
        public List<Pair<Integer, Integer>> the_list;

        @Override
        public String toString() {
            return "Demo{" +
                    "x=" + x +
                    ", y=" + y +
                    ", the_list=" + the_list +
                    '}';
        }
    }

    static class PairSerializer extends JsonSerializer<Pair> {

        @Override
        public void serialize(
                Pair pair,
                JsonGenerator jsonGenerator,
                SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeStartArray(2);
            jsonGenerator.writeObject(pair.getLeft());
            jsonGenerator.writeObject(pair.getRight());
            jsonGenerator.writeEndArray();
        }
    }

    static class PairDeserializer extends JsonDeserializer<Pair> {

        @Override
        public Pair deserialize(
                JsonParser jsonParser,
                DeserializationContext deserializationContext) throws IOException {
            final Object[] array = jsonParser.readValueAs(Object[].class);
            return Pair.of(array[0], array[1]);
        }
    }

    public static void main(String[] args) throws IOException {
        final SimpleModule module = new SimpleModule();
        module.addSerializer(Pair.class, new PairSerializer());
        module.addDeserializer(Pair.class, new PairDeserializer());
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(module);
        final Demo demo = objectMapper.readValue(JSON, Demo.class);
        System.out.println("toString: " + demo);
        System.out.println("Input: " + JSON);
        System.out.println("Output: " + objectMapper.writeValueAsString(demo));
    }
}