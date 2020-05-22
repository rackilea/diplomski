private MethodDoc[] getTestMethods(RootDoc root) {
    List<MethodDoc> result = new ArrayList<MethodDoc>();
    for (ClassDoc c : root.classes()) {
        for(MethodDoc m : c.methods()) {
            if (isTest(m))
                result.add(m);
        }
    }
    return result.toArray(new MethodDoc[0]);
}

// simplified test detection
private static boolean isTest(MethodDoc m) {
    for(AnnotationDesc a: m.annotations()) {
        if (a.annotationType().name().equals("Test"))
            return true;
    }
    return false;
}