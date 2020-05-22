// using SimpleEntry from java.util.AbstractMap
Set<Student> list = new HashSet<>(studentStream
    .flatMap(student -> student.getSubjects().stream()
        .map(subject -> new SimpleEntry<>(subject, student)))
    .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (l, r) -> Student.SENTINEL_VALUE)
    .values());
list.remove(Student.SENTINEL_VALUE);