static void printMinMax(List<Student> students) {
  Comparator<Student> comparator = (s1, s2) -> s1.getGrade() - s2.getGrade();

  Student max = Collections.max(students, comparator);
  Student min = Collections.min(students, comparator);

  // print stuff
}