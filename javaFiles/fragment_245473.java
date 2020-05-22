class Student implements Cloneable {
  //Contained object
  private Subject subj;
  private String name;

  public Subject getSubj() {..}
  public String getName() {..}

  public Object clone() {
    //Deep copy
    Student s = new Student(name, subj.getName());
    return s;
  }
}