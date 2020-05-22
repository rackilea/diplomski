public void serialize(Object bean, JsonGenerator jgen,
                SerializerProvider provider) throws IOException,
                JsonGenerationException {           
            jgen.writeStartObject();                        
            serializeFields(bean, jgen, provider);
            jgen.writeStringField("extraField", "extraFieldValue"); 
            jgen.writeEndObject();
        }