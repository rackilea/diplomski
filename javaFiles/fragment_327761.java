private static Grade value(Student s) {
    return new Grade(s.getGrade(), new ArrayList<>(Collections.singleton(s)));
}

private static Grade merge(Grade g1, Grade g2) {
    g1.getStudents().addAll(g2.getStudents());
    return g1;
}