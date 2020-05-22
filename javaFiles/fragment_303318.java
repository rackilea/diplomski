// Add fields declared on this type
Field[] fields;
if (Options.respectJavaAccessibility) {
    // returns just the public fields
    fields = forClass.getFields();
} else {
    fields = forClass.getDeclaredFields();
    for (Field field : fields) {
        field.setAccessible(true);
    }
}