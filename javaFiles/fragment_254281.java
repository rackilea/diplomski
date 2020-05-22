static class TypedParam {
    final TypeToken<?> type;
    final Object object;
    private TypedParam(TypeToken<?> type, Object object) {
        this.type = type;
        this.object = object;
    }
}

public static class Context {
    Map<String, TypedParam> params = new HashMap<>();
    TypedParam get(String name) {
        return params.get(name);
    }
}

public static <T> T getParameter(final Context context, final String name, final TypeToken<T> type) {
    TypedParam param = context.get(name);
    if (type.isAssignableFrom(param.type)) {
        @SuppressWarnings("unchecked")
        T ret = (T)param.object;
        return ret;
    } else {
        throw new ClassCastException(param.type + " cannot be assigned to " + type);
    }
}