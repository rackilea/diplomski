public class MyTypeIdResolver extends TypeIdResolverBase {

    @Override
    public String idFromValue(Object value) {
        return getId(value);
    }

    @Override
    public String idFromValueAndType(Object value, Class<?> suggestedType) {
        return getId(value);
    }

    @Override
    public JsonTypeInfo.Id getMechanism() {
        return JsonTypeInfo.Id.CUSTOM;
    }

    private String getId(Object value) {
        if (value instanceof ListWrapper.MyMapListWrapper) {
            return "MyMap[]";
        }

        if (value instanceof ListWrapper.Child1ListWrapper) {
            return "Child1[]";
        }

        if (value instanceof ListWrapper && !((ListWrapper) value).getValues().isEmpty()) {
            return ((ListWrapper) value).getValues().get(0).getClass().getSimpleName() + "[]";
        }

        return value.getClass().getSimpleName();
    }

    @Override
    public JavaType typeFromId(DatabindContext context, String id) throws IOException {
        if (id.endsWith("[]")) {
            if (id.startsWith("Child1")) {
                return TypeFactory.defaultInstance().constructParametricType(ListWrapper.class, Child1.class);
            }
            if (id.startsWith("MyMap")) {
                return TypeFactory.defaultInstance().constructSpecializedType(TypeFactory.unknownType(), ListWrapper.MyMapListWrapper.class);
            }
        }
        if (id.equals("Child1")) {
            return TypeFactory.defaultInstance().constructSpecializedType(TypeFactory.unknownType(), Child1.class);
        }
        if (id.equals("MyMap")) {
            return TypeFactory.defaultInstance().constructSpecializedType(TypeFactory.unknownType(), MyMap.class);
        }

        return TypeFactory.unknownType();
    }
}