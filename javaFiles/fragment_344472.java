public class UserEventDeserializer extends StdDeserializer<User> implements ResolvableDeserializer
{
  private static final long serialVersionUID = 7923585097068641765L;

  private final JsonDeserializer<?> defaultDeserializer;

  public UserEventDeserializer(JsonDeserializer<?> defaultDeserializer)
  {
    super(User.class);
    this.defaultDeserializer = defaultDeserializer;
  }

  @Override public User deserialize(JsonParser jp, DeserializationContext ctxt)
      throws IOException, JsonProcessingException
  {
    User deserializedUser = (User) defaultDeserializer.deserialize(jp, ctxt);

    // Special logic

    return deserializedUser;
  }

  // for some reason you have to implement ResolvableDeserializer when modifying BeanDeserializer
  // otherwise deserializing throws JsonMappingException??
  @Override public void resolve(DeserializationContext ctxt) throws JsonMappingException
  {
    ((ResolvableDeserializer) defaultDeserializer).resolve(ctxt);
  }


  public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException
  {
    SimpleModule module = new SimpleModule();
    module.setDeserializerModifier(new BeanDeserializerModifier()
    {
      @Override public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config, BeanDescription beanDesc, JsonDeserializer<?> deserializer)
      {
        if (beanDesc.getBeanClass() == User.class)
          return new UserEventDeserializer(deserializer);
        return deserializer;
      }
    });


    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(module);
    User user = mapper.readValue(new File("test.json"), User.class);
  }
}