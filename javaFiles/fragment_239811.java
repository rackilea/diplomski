@Autowired
    public Serializer(List<IDeserializer> deserializers) {
        SimpleModule module = new SimpleModule("name");
        registerDeserializers(module, deserializers);
        mapper.registerModule(module);
        mapper.configure(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS, true);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
    }

    private void registerDeserializers(SimpleModule module, List<IDeserializer> deserializers) {
        if (CollectionUtils.isNotEmpty(deserializers)) {
            final Map<Class<?>, IDeserializer> deserializerRegistryMap = toMap(deserializers);
            module.setDeserializerModifier(new BeanDeserializerModifier() {
                @Override
                public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config, BeanDescription beanDesc, JsonDeserializer<?> deserializer) {
                    if (deserializerRegistryMap.containsKey(beanDesc.getBeanClass())){
                        return deserializerRegistryMap.get(beanDesc.getBeanClass()).getDeserializer(mapper);
                    }
                    return super.modifyDeserializer(config, beanDesc, deserializer);
                }
            });
        }
    }


@Component
public class MigrationDeserializer {

    @Autowired
    private MigratorRegistry migratorRegistry;

    public <T> JsonDeserializer<T> createDeserializer(final ObjectMapper mapper, final Class<T> returnType, final Class<? extends SerializedObjectsHistory<T>> historyType){
       return new StdDeserializer<T>(returnType){

           @Override
           public T deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
               SerializedObjectsHistory<T> history = mapper.readValue(p, historyType);
               return migratorRegistry.migrate(history, returnType);
           }
       };
    }
}