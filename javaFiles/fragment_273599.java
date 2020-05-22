List<Student> students = new ArrayList<Student>();
students.add(new Student(1, "bob", 15));
students.add(new Student(2, "Jane", 14));
students.add(new Student(3, "Gary", 16));

SortedSet<Student> set1 = new TreeSet<Student>(new AgeComparator());
set1.addAll(students);
for (Student student : set1) {
  // age order
}