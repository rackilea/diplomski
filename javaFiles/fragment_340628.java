public static Collection<Object> getAnnotatedValues(final Object root) throws ReflectiveOperationException {
    return getAnnotatedValues(root, new HashSet<>());
}

private static Collection<Object> getAnnotatedValues(final Object root, final Set<Object> inspected)
        throws ReflectiveOperationException {
    final List<Object> annotatedValues = new ArrayList<>();
    if (inspected.contains(root)) { // Prevents stack overflow.
        return Collections.EMPTY_LIST;
    }
    inspected.add(root);
    for (final Field field : gatherFields(root.getClass())) {
        field.setAccessible(true);
        final Object currentValue = field.get(root);
        field.setAccessible(false);
        if (field.isAnnotationPresent(RequiredParam.class)) {
            // Found required value, search finished:
            annotatedValues.add(currentValue);
            if (currentValue != null) {
                inspected.add(currentValue);
            }
        } else if (currentValue != null) {
            // Searching for annotated fields in nested classes:
            annotatedValues.addAll(getAnnotatedValues(currentValue, inspected));
        }
    }
    return annotatedValues;
}

private static Iterable<Field> gatherFields(Class<?> fromClass) {
    // Finds ALL fields, even the ones from super classes.
    final List<Field> fields = new ArrayList<>();
    while (fromClass != null) {
        fields.addAll(Arrays.asList(fromClass.getDeclaredFields()));
        fromClass = fromClass.getSuperclass();
    }
    return fields;
}