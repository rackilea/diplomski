.forEach(field -> {
    String fieldName = field.getType().getSimpleName();
    String enumTypeName = StringUtils.uncapitalize(fieldName);
    Map<String, Properties> enumProperties 
        = cachedProperties.computeIfAbsent(enumTypeName, key -> {
                try {
                    return loadPropsForType(key);
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            });
    mergeProperties(enumProperties, localProperties);
});