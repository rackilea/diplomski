public Map<Subject, Set<Standard>> getSubjectWiseStandards() {
    if (this.standardWiseSubjects == null) {
        return null;
    }

    return this.standardWiseSubjects.entrySet().parallelStream()
        .<Map.Entry<Subject, Standard>> flatMap(
                e -> e.getValue().stream()
                    .map(st -> new AbstractMap.SimpleEntry<>(st, e.getKey())))
        .collect(Collectors.groupingBy(e -> e.getKey(), 
                 Collectors.mapping(e -> e.getValue(), 
                 Collectors.toSet())));
}