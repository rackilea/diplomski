ArrayList<Student> studentList = new ArrayList<Student>();
studentList.add(new Student("Milind", 1, 7.73));
studentList.add(new Student("Milind", 1, 7.70));
studentList.add(new Student("Mike", 1, 7.80));
System.out.println("--Unsorted--");

for (Student student : studentList) {
    System.out.print(student.name + ": ");
    System.out.print(student.gpa);
    System.out.println();
}
System.out.println();

Collections.sort(studentList);
System.out.println("--Sorted--");

for (Student student : studentList) {
    System.out.print(student.name + ": ");
    System.out.print(student.gpa);
    System.out.println();
}