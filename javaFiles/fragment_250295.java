for (Field field : clazz.getDeclaredFields()) {
    if (field.isAnnotationPresent(MyAnnotation.class)) {
        field.setAccessible(true);
        String fieldName = field.getName();
        Object fieldValue = field.get(myObj);
        field.setAccessible(false);
    }
}