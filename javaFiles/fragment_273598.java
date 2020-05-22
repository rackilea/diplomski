public class AgeComparator implements Comparator<Student> {
  public int compare(Student s1, Student s2) {
    if (s1.getAge() == s2.getAge()) {
      return 0;
    } else {
      return s1.getAge() < s2.getAge() ? -1 : 1;
  }
}