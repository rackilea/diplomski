private <T> List<Predicate> filterInDepth(Map<String, String> params, Root<T> root,
        CriteriaBuilder criteriaBuilder, String field, Class<T> clazz)
        throws NoSuchFieldException {
    List<Predicate> predicates = new ArrayList<>();
    String[] compositeFields = field.split(REGEX_FIELD_SPLITTER);

    if (isNestedFieldExists(clazz, compositeFields)) {
        Path path = null;
        for (String part : compositeFields) {
            if (path == null) {
                path = root.get(part);
            }
            else {
                path = path.get(part);
            }
        }

        predicates.add(criteriaBuilder.equal(path, params.get(field)));
    }

    return predicates;
}

private boolean isNestedFieldExists(Class clazz, String[] fieldChain)
        throws NoSuchFieldException {
    for (String field : fieldChain) {
        Field f = clazz.getDeclaredField(field);
        if (f.getType() == null) {
            return false;
        }

        clazz = f.getType();
    }

    return true;
}