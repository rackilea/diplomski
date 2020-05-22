public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) 
{
    ParameterizedType paramType = (ParameterizedType) genericType;

    if(paramType.getRawType().equals(JaxbList.class))
    {
        return true;
    }

    return false;
}