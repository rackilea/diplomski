Predicate<ComplexObject> cobjFilter(List<String> allowedTags) {
    return cobj -> allowedTags.contains(cobj.getTag());
}

    List<String> allowedTags = ... ;
    List<ComplexObject> result =
        retrieveAllComplexObjects2()
            .filter(cobjFilter(allowedTags))
            .collect(toList());