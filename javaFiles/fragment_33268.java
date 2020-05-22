@Test
public void calls_general_deserializer_for_parameterized_interface() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new SimpleModule() {
        @Override
        public void setupModule(SetupContext context) {
            context.addDeserializers(new Deserializers.Base() {
                @Override
                public JsonDeserializer<?> findEnumDeserializer(Class<?> type,
                        DeserializationConfig config,
                        BeanDescription beanDesc) throws JsonMappingException {
                    if (IEnumerable.class.isAssignableFrom(type)) return new EnumerableDeserializer(type);
                    return null;
                }
            });
            super.setupModule(context);
        }
    });
    TestData data = mapper.readerFor(TestData.class).with(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)
            .with(JsonParser.Feature.ALLOW_SINGLE_QUOTES).readValue("{ recordType: 'AAAA' }");
    assertThat(data.recordType, equalTo(DnsRecordType.DNS_TYPE_AAAA));
}

public static final class EnumerableDeserializer<E extends Enum<E> & IEnumerable<E>> extends
        StdScalarDeserializer<E> {
    private final Class<? extends AbstractEnumerable<E>> enumerationClass;
    private final Class<E> enumerableClass;

    public EnumerableDeserializer(Class<E> enumerableClass) {
        super(enumerableClass);
        this.enumerableClass = enumerableClass;
        this.enumerationClass = (Class<? extends AbstractEnumerable<E>>) enumerableClass.getEnclosingClass();
    }

    @Override
    public E deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        AbstractEnumerable<E> enumerable = getEnumeration();
        return enumerable.getByName(p.getText());
    }

    private AbstractEnumerable<E> getEnumeration() {
        return EnumerationFactory.getInstance().create(enumerationClass);
    }
}