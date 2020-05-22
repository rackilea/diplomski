public Set<Student> getTutees() {
    Set newSet = new HashSet();
    for (Student tutee : tutees) {
        newSet.add(new Student(tutee.getName(), tutee.getCourse()));
    }
    return newSet;
}