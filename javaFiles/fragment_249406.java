@Entity public class Course {
  ...
  @ManyToMany
  @OrderBy("lastname ASC")
  public List<Student> getStudents() {...};
  ...
}