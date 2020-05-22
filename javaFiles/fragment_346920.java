protected JsonMappingException wrapException(Throwable t)
{
    while (t.getCause() != null) {
        t = t.getCause();
    }
    if (t instanceof JsonMappingException) {
        return (JsonMappingException) t;
    }
    return new JsonMappingException("Instantiation of "+getValueTypeDesc()+" value failed: "+t.getMessage(), t);
}