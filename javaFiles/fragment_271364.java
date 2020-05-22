static void printMinMax(List<Student> students) {
  Comparator<Student> comparator = new Comparator<>() {
    @Override public int compare(Student s1, Student s2) {
      return s1.getGrade() - s2.getGrade();
    }
  };
  Student max = Collections.max(students, comparator);
  Student min = Collections.min(students, comparator);

  // print stuff
}