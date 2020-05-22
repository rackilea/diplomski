public static Specification<Employee> textInAllColumns(Object value) {
    return (root, query, builder) -> builder.or(root.getModel().getDeclaredSingularAttributes().stream()
            .filter(attr -> attr.getJavaType().equals(value.getClass()))
            .map(attr -> map(value, root, builder, attr))
            .toArray(Predicate[]::new));
}

private static Object map(Object value, Root root, CriteriaBuilder builder, SingularAttribute a) {
    switch (value.getClass().getSimpleName()) {
        case "String":
            return builder.like(root.get(a.getName()), getString((String) value));
        case "Integer":
            return builder.equal(root.get(a.getName()), value);
        case "Date":
            return //date mapping
        default:
            return //default;
    }
}