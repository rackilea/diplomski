private static Set<String> pathsToSkip(Class<?> clazz) {
    // Make sure that the class is annotated with XmlRootElement
    XmlRootElement rootElement = clazz.getAnnotation(XmlRootElement.class);
    if (rootElement == null) {
        throw new IllegalArgumentException("XmlRootElement is missing");
    }
    // Create the root name from the annotation or from the class name
    String rootName = ("##default".equals(rootElement.name()) ?
    clazz.getSimpleName().substring(0, 1).toLowerCase() + clazz.getSimpleName().substring(1) :
    rootElement.name());
    // Set that will contain all the paths
    Set<String> pathsToSkip = new HashSet<>();        
    addPathsToSkip(rootName, clazz, pathsToSkip);
    return pathsToSkip;
}

private static void addPathsToSkip(String parentPath, Class<?> clazz, 
                               Set<String> pathsToSkip) {
    // Iterate over all the fields
    Field[] fields = clazz.getDeclaredFields();
    for (Field field : fields) {
        XmlElement xmlElement = field.getAnnotation(XmlElement.class);
        if (xmlElement != null) {
            // Create the name of the element from the annotation or the field name
            String elementName = ("##default".equals(xmlElement.name()) ?
            field.getName() :
            xmlElement.name());
            String path = parentPath + "/" + elementName;
            if (xmlElement.nillable()) {
                // It is nillable so we add it to the paths to skip
                pathsToSkip.add(path);
            } else {
                // It is not nillable so we check the fields corresponding 
                // to the field type

                // If it's a collection we need to get the generic type
                if (Collection.class.isAssignableFrom(field.getType())) {
                    ParameterizedType fieldGenericType = (ParameterizedType) field
                        .getGenericType();
                    Class<?> fieldGenericTypeClass = (Class<?>) fieldGenericType
                        .getActualTypeArguments()[0];
                    addPathsToSkip(path, fieldGenericTypeClass, pathsToSkip);
                } else {
                    addPathsToSkip(path, field.getType(), pathsToSkip);
                }
            }
        }
    }
}