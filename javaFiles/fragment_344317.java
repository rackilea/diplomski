public class NullCollectionHandler extends SimpleModule {
    private static class CustomizedCollectionDeserialiser extends CollectionDeserializer {

        public CustomizedCollectionDeserialiser(CollectionDeserializer src) {
            super(src);
        }

        private static final long serialVersionUID = 1L;

        @Override
        public Collection<Object> deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            Collection<Object> oldCol = super.deserialize(jp, ctxt);
            Collection<Object> newCol = new ArrayList<Object>();
            if(CollectionUtils.isNotEmpty(oldCol)){
                for(Object obj : oldCol){
                    if(obj != null)
                    newCol.add(obj);
                }
            }
            return newCol;
        }

        @Override
        public CollectionDeserializer createContextual(DeserializationContext ctxt,
                BeanProperty property) throws JsonMappingException {
            return new CustomizedCollectionDeserialiser(super.createContextual(ctxt, property));
        }
    }

    private static final long serialVersionUID = 1L;

    @Override
    public void setupModule(SetupContext context) {
        super.setupModule(context);
        context.addBeanDeserializerModifier(new BeanDeserializerModifier() {
            @Override
            public JsonDeserializer<?> modifyCollectionDeserializer(
                    DeserializationConfig config, CollectionType type,
                    BeanDescription beanDesc, JsonDeserializer<?> deserializer) {
                if (deserializer instanceof CollectionDeserializer) {
                    return new CustomizedCollectionDeserialiser(
                        (CollectionDeserializer) deserializer);
                } else {
                    return super.modifyCollectionDeserializer(config, type, beanDesc,
                        deserializer);
                }
            }
        });
    }
}