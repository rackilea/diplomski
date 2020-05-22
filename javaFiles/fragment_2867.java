public class Response {
  @XmlJavaTypeAdapter(MapAdapter.class)    

  HashMap<Integer, Student> students;

  public HashMap<Integer, Student> getStudents() {
    return students;
  }

  public void setStudents(HashMap<Integer, Student> map) {
    this.students = map;
  }
}