public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException
{
    // any JSON value you want...
    if(value==null) {
    jgen.writeString("");
    }
}