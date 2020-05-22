protected TypeReference()
{
    Type superClass = getClass().getGenericSuperclass();
    if (superClass instanceof Class<?>) { // sanity check, should never happen
        throw new IllegalArgumentException("Internal error: TypeReference constructed without actual type information");
    }
    ...
    _type = ((ParameterizedType) superClass).getActualTypeArguments()[0];
}