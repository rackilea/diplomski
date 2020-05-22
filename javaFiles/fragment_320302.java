static Set<String> getMethodGroups(MethodDoc m) {
    Set<String> result = getGroups(m);
    result.addAll(getGroups(m.containingClass()));
    return result;
}

static Set<String> getGroups(ProgramElementDoc m) {
    Set<String> result = new HashSet<String>();
    for(AnnotationDesc a: m.annotations()) {
        if (a.annotationType().name().equals("Test")) {
            for(ElementValuePair ev : a.elementValues()) {
                if (ev.element().name().equals("groups")) {
                    String value = ev.value().toString();
                    StringTokenizer tokenizer = new StringTokenizer(value, "{}\", ");
                    while (tokenizer.hasMoreElements()) {
                        result.add(tokenizer.nextToken());
                    }
                }
            }
        }
    }
    return result;
}