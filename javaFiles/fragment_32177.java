class TypeSimpleName {

    private final Type value;

    public TypeSimpleName(Type value) {
        this.value = value;
    }

    public String getName() {
        return getName(value);
    }

    private String getName(Type type) {
        if (type instanceof ParameterizedType) {
            return getParameterizedTypeName((ParameterizedType) type);
        }
        if (type instanceof Class) {
            return getClassSimpleName(type);
        }
        // handle other types if needed

        return type.getTypeName();
    }

    private String getParameterizedTypeName(ParameterizedType type) {
        StringBuilder builder = new StringBuilder();

        builder.append(getName(type.getRawType()));
        Type[] typeArguments = type.getActualTypeArguments();
        if (typeArguments.length > 0) {
            builder.append("<");
            for (int i = 0; i < typeArguments.length; i++) {
                Type arg = typeArguments[i];
                builder.append(getName(arg));
                if (i < typeArguments.length - 1) {
                    builder.append(", ");
                }
            }
            builder.append(">");
        }

        return builder.toString();
    }

    private String getClassSimpleName(Type type) {
        return ((Class) type).getSimpleName();
    }

    @Override
    public String toString() {
        return getName();
    }
}