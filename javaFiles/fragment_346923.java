public class MyValueInstantiator extends StdValueInstantiator {
    public MyValueInstantiator(DeserializationConfig config, Class<?> valueType) {
        super(config, valueType);
    }

    @Override
    protected JsonMappingException wrapException(Throwable t) {
        if (t instanceof JsonMappingException) {
            return (JsonMappingException) t;
        }
        return new JsonMappingException("Instantiation of "+getValueTypeDesc()+" value failed: "+t.getMessage(), t);
    }
}