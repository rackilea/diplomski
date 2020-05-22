// assume students.length > 0
static void printMinMax(Student[] students) {
  Student min = students[0];
  Student max = students[0];

  for (Student student: students) {
    if (student.getGrade() > max.getGrade())
      max = student;
    if (student.getGrade() < min.getGrade())
      min = student;
  }

  System.out.println("Best student: " + max);
  System.out.println("Worst student: "+ min);
}