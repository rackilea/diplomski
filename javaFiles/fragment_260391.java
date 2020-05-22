private Optional<String> fetchByNumList(ObjectId objectId) {
    return objectId.getNumList().stream()
            .map(n -> n.getNumRefList().stream()
                    .map(REGEX_PATTERN::matcher)
                    // pre Java 11 .filter(m -> !m.matches())
                    .filter(Predicate.not(Matcher::matches))
                    .findAny()
                    .map(p -> Optional.of(p.group(3)))
                    .orElse(Optional.empty()))
            .findAny()
            .orElse(Optional.empty());
}