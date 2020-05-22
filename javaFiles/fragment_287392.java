public class IdResolver implements TypeIdResolver {

    private JavaType baseType = null;

    @Override
    public void init(JavaType baseType) {
        this.baseType = baseType;
    }

    @Override
    public String idFromValue(Object value) {
        return idFromValueAndType(value, value.getClass());
    }

    @Override
    public String idFromValueAndType(Object value, Class<?> suggestedType) {
        String id = "";
        for (Map.Entry<String, Class<? extends IPolymorphic>> entry : PolymorphicTypeRegistry.Companion.getInstance().getMap().entrySet()) {
            if (entry.getValue() == suggestedType) return entry.getKey();
        }        
        return id;
    }

    @Override
    public String idFromBaseType() {
        return idFromValueAndType(null, baseType.getRawClass());
    }

    @Override
    public JavaType typeFromId(String id) {
        Class clazz = PolymorphicTypeRegistry.Companion.getInstance().get(id);
        JavaType javaType = TypeFactory.defaultInstance().constructSpecializedType(baseType, clazz);
        return javaType;
    }

    @Override
    public JavaType typeFromId(DatabindContext context, String id) {
        return typeFromId(id);
    }

    @Override
    public String getDescForKnownTypeIds() {
        return "";
    }

    @Override
    public JsonTypeInfo.Id getMechanism() {
        return JsonTypeInfo.Id.CUSTOM;
    }
}