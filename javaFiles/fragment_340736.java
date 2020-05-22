public class OrderMixin {

    @JsonDeserialize( using = OrderKeyDeserializer.class )
    @JsonSerialize( using = OrderKeySerializer.class )
    @JsonProperty( "_key" )
    OrderKey key;

    @JsonProperty( "description" )
    String description;

    @JsonProperty( "amount" )
    String amount;

    @JsonProperty( "operation" )
    Order.Operation operation;

    @JsonProperty( "creationDate" )
    LocalDateTime creationDate;

    public static class OrderKeySerializer extends JsonSerializer<OrderKey> {

        public OrderKeySerializer() {
            super( OrderKey.class );
        }

        @Override
        public void serialize( OrderKey value, JsonGenerator gen, SerializerProvider provider ) throws IOException {
            gen.writeString( value.getOrderId() );
        }
    }

    public static class OrderKeyDeserializer extends JsonDeserializer<OrderKey> {

        public OrderKeyDeserializer() {
            super( OrderKey.class );
        }

        @Override
        public OrderKey deserialize( JsonParser jsonParser, DeserializationContext context ) throws IOException {
            JsonNode node = jsonParser.getCodec().readTree( jsonParser );

            return OrderKey.get( node.asText() );
        }
    }

}