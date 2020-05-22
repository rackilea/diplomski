private Class<?>[] buildParameterTypes(final List<String> types) {
    return types.stream()
                .map(typeStr -> {
                    try {
                        return Class.forName(typeStr);
                    } catch (final ClassNotFoundException e) {
                        throw new IllegalArgumentException(e);
                    }
                }).toArray(Class[]::new);
}