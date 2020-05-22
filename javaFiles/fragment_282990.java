public class ProgramsCollectionHandler extends SimpleModule {
    private static class ProgramsCollectionDeserializer extends CollectionDeserializer {

        public ProgramsCollectionDeserializer(CollectionDeserializer deserializer) {
            super(deserializer);
        }

        private static final long serialVersionUID = 1L;

        @Override
        public Collection<Object> deserialize(JsonParser parser, DeserializationContext context)
                throws IOException, JsonProcessingException {
            Collection<Object> result = super.deserialize(parser, context);
            Collection<Object> filteredResult = new ArrayList<Object>();
            for (Object o : result) {
                if (o instanceof Programs) {
                    final Programs programs = (Programs) o;
                    if (programs.exists) {
                        filteredResult.add(programs);
                    }
                }
            }
            return filteredResult;
        }

        @Override
        public CollectionDeserializer createContextual(
                DeserializationContext context,
                BeanProperty property) throws JsonMappingException {
            return new ProgramsCollectionDeserializer(super.createContextual(context, property));
        }
    }

    private static final long serialVersionUID = 1L;

    @Override
    public void setupModule(Module.SetupContext context) {
        super.setupModule(context);
        context.addBeanDeserializerModifier(new BeanDeserializerModifier() {
            @Override
            public JsonDeserializer<?> modifyCollectionDeserializer(
                    DeserializationConfig config, CollectionType type,
                    BeanDescription beanDesc, JsonDeserializer<?> deserializer) {
                if (deserializer instanceof CollectionDeserializer) {
                    return new ProgramsCollectionDeserializer(
                            (CollectionDeserializer) deserializer);
                }
                return super.modifyCollectionDeserializer(config, type, 
                        beanDesc, deserializer);
            }
        });
    }
}