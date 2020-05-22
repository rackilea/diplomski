public class Roster
{
  ArrayList<Student> students;
  public Roster()
  {
    students = new ArrayList<Student>();
  }
  public void addStudent(Student student)
  {
    if(student == null)
      throw new IllegalArgumentException;
    students.add(student);
  }
  public void addStudent(String firstname, String lastname, String grade)
  {
   Student student = new Student(firstname, lastname, grade);//assuming there is this constructor
   //If you don't have that constructor you might have some setters use them.
   students.add(student);
  }
}