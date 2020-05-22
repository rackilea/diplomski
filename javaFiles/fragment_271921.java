Deserializers d = new Deserializers.Base() {

   @Override
   public JsonDeserializer<?> findEnumDeserializer(Class<?> type, DeserializationConfig config, BeanDescription beanDesc, BeanProperty property)
                  throws JsonMappingException {
                if (property.getType().getContentType() != null)
                    return new EnumDeserializer(property.getType().getContentType().getRawClass());
                return new EnumDeserializer(property.getType().getRawClass());
            }

        };
        mapper.setDeserializerProvider(mapper.getDeserializerProvider().withAdditionalDeserializers(d));