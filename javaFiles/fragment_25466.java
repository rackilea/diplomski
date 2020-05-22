Set<Student> seenStudents = new HashSet<>();
for (int index = 0; index< students.length; index++) {
    Student student = students[index];
    if (seenStudents.add(student)) {
       // do something
    } else {
       // I want to do something else
    }
}