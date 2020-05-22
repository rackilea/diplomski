boolean cobjFilter(ComplexObject cobj) {
    List<String> allowedTags = ... ;
    return allowedTags.contains(cobj.getTag());
}

    List<ComplexObject> result =
        retrieveAllComplexObjects2()
            .filter(this::cobjFilter)
            .collect(toList());