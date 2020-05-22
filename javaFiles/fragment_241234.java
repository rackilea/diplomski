for (Field field : YourClass.class.getDeclaredFields()) {
    try {
        Annotation annotation = field.getAnnotation(PrimaryKey.class);
        // what you want to do with the field
    } catch (NoSuchFieldException e) {
        // ...
    }
}