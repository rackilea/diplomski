public class CustomSerializer extends Jackson2JsonRedisSerializer
{
    public JurisdictionsSerializer(Class type)
    {
        super(type);
    }


    @Override
    protected JavaType getJavaType(Class clazz)
    {
        return TypeFactory.defaultInstance()
                .constructMapType(Map.class, Integer.class, String.class);
    }
}