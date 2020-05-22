Student bad = new Student("bad");
bad.setMarks(2);
Student meh = new Student("meh");
meh.setMarks(5);
Student good = new Student("good");
good.setMarks(10);
Student otherGood = new Student("otherGood");
otherGood.setMarks(10);

// initializes a Set of students
Set<Student> students = new HashSet<Student>();
// adds the students
students.add(meh);
students.add(bad);
students.add(good);
students.add(otherGood);
// prints the "best student"
System.out.println(Collections.max(students).getName());
// initializing Set of best students
List<Student> bestStudents = new ArrayList<Student>();
// finding best mark
int bestMark = Collections.max(students).getMarks();
// adding to best students if has best mark
for (Student s: students) {
    if (s.getMarks() == bestMark) {
        bestStudents.add(s);
    }
}
// printing best students
for (Student s: bestStudents) {
    System.out.println(s.getName());
}