public class JacksonDeserializer extends StdDeserializer<MyPojo>
    implements ContextualDeserializer
{
    private static final long serialVersionUID = 1L;
    /**
     * The JSON property being deserialized (null if root object).
     */
    private final BeanProperty property;

    JacksonDeserializer()
    {
        super(MyPojo.class);
        this.property = null;
    }

    /**
     * @param property the JSON property being deserialized (null if root object)
     */
    JacksonDeserializer(BeanProperty property)
    {
        super(MyPojo.class);
        this.property = property;
    }

    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property)
        throws JsonMappingException
    {
        return new JacksonDeserializer(property);
    }

    @Override
    public MyPojo deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException
    {
        MyInjectable injectable = (MyInjectable) ctxt.findInjectableValue("myInjectable", property, null);
        assert (scope != null);
        // The rest of the deserializer goes here
    }
}