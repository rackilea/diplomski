.addSerializationExclusionStrategy(new ExclusionStrategy() {
    @Override
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
    return fieldAttributes.getAnnotation(ExcludeWebSocketSerialization.class) != null;
    }

    @Override
    public boolean shouldSkipClass(Class<?> aClass) {
    return false;
    }
})