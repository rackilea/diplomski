class StudentVO {
  private String name;
  private int age;
  public String getName() {
      return name;
  }
  public void setName(String name) {
      this.name = name;
  }
  public int getAge() {
      return age;
  }
  public void setAge(int age) {
      this.age = age;
  }
}

class AgeComparator implements Comparator<StudentVO> {

@Override
public int compare(StudentVO o1, StudentVO o2) {
    Integer age1 = o1.getAge();
    Integer age2 = o2.getAge();
    return age1.compareTo(age2);
  }

}

class NameComparator implements Comparator<StudentVO> {

  @Override
  public int compare(StudentVO o1, StudentVO o2) {
      return o1.getName().compareTo(o2.getName());
  }

}