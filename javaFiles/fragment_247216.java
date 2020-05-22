public class JacksonJodaMoney {

    public static class Product {
        public final Money price;

        @JsonCreator
        public Product(@JsonProperty("price") Money price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "price=" + price +
                    '}';
        }
    }

    private static class MoneySerializer extends StdSerializer<Money> {
        protected MoneySerializer() {
            super(Money.class);
        }

        @Override
        public void serialize(Money value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
            jgen.writeString(value.toString());
        }
    }

    private static class MoneyDeserializer extends StdDeserializer<Money> {
        protected MoneyDeserializer() {
            super(Money.class);
        }

        @Override
        public Money deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
            return Money.parse(jp.readValueAs(String.class));
        }
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Product value = new Product(Money.of(CurrencyUnit.EUR, 40.55));
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Money.class, new MoneyDeserializer());
        module.addSerializer(Money.class, new MoneySerializer());
        mapper.registerModule(module);
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(value);
        System.out.println(json);
        System.out.println(mapper.readValue(json, Product.class));
    }
}