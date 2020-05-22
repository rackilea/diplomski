public void addStandardWiseSubject(Subject subject, Standard standard) {
    if (this.standardWiseSubjects == null) {
        this.standardWiseSubjects = new HashMap<>();
    }
    this.standardWiseSubjects.computeIfAbsent(standard,
            s -> new HashSet<>()).add(subject);
}