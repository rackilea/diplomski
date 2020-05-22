public Map<Subject, Set<Standard>> getSubjectWiseStandards() {
    if (this.standardWiseSubjects == null) {
        return null;
    }

    return EntryStream.of(this.standardWiseSubjects).parallel()
            .invert().flatMapKeys(Set::stream).groupingTo(HashSet::new);
}