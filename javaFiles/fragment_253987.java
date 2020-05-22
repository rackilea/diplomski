public class DynamicPropertyFilter implements PropertyFilter {
    public void serializeAsField(Object pojo, JsonGenerator jgen, SerializerProvider prov, PropertyWriter writer) throws Exception {
        if (writer instanceof BeanPropertyWriter) {
            BeanPropertyWriter bWriter = (BeanPropertyWriter) writer;

            String fieldName = bWriter.getFullName().getSimpleName();
            Field field = pojo.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            Object object = field.get(pojo);

            if (Double.class.isInstance(object) && (double) object == 0.0) {
                // Remove all double fields that are equal to 0.0
                bWriter.serializeAsOmittedField(pojo, jgen, prov);
                return;
            } else if (Boolean.class.isInstance(object)) {
                // Change all boolean fields to 1 and 0 instead of true and false
                prov.defaultSerializeField(fieldName, (boolean) object ? 1 : 0, jgen);
                return;
            }
        }

        // Serialize field as normal if property is not filtered
        writer.serializeAsField(pojo, jgen, prov);
    }

    public void serializeAsElement(Object elementValue, JsonGenerator jgen, SerializerProvider prov, PropertyWriter writer) throws Exception {
        writer.serializeAsField(elementValue, jgen, prov);
    }

    public void depositSchemaProperty(PropertyWriter writer, JsonObjectFormatVisitor objectVisitor, SerializerProvider provider) throws JsonMappingException {
        writer.depositSchemaProperty(objectVisitor, provider);
    }

    @Deprecated
    public void depositSchemaProperty(PropertyWriter writer, ObjectNode propertiesNode, SerializerProvider provider) throws JsonMappingException {
        writer.depositSchemaProperty(propertiesNode, provider);
    }
}