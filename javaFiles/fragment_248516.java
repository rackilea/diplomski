// Using the Collection<? extends E> constructor:
List<Student> studentsA = new ArrayList<>(collegeStudents);
// Using Collections.unmodifiableList which returns
// an unmodifiable view of the List<CollegeStudent>
// as a List<Student> without copying its elements:
List<Student> studentsB = Collections.unmodifiableList(collegeStudents);
// Older versions of Java might require a type
// witness for Collections.unmodifiableList:
List<Student> studentsC = Collections.<Student>unmodifiableList(collegeStudents);