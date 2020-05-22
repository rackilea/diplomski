public List<ComplexObject> retrieveObjectsFilteredBy(Predicate<ComplexObject> pred) {
    List<ComplexObject> complexObjects = retrieveAllComplexObjects();
    return complexObjects.stream()
        .filter(pred)
        .collect(Collectors.toList());
}