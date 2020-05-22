public class StudentDaoImpl implements StudentDao {
    //list is working as a database
   private static final List<Student> students;

   public StudentDaoImpl() {
      students = new ArrayList<Student>();
      students.add(new Student("Student 0", 0));
      students.add(new Student("Student 1", 1));        
   }

   @Override
   public void deleteStudent(Student student) {
      students.remove(student.getRollNo());
      System.out.println("Student: Roll No " + student.getRollNo() + ", deleted from database");
   }

   @Override
   public List<Student> getAllStudents() {
      return students;
   }

   @Override
   public Student getStudent(int rollNo) {
      return students.get(rollNo);
   }

   @Override
   public void updateStudent(Student student) {
      Student foundStudent = students.get(student.getRollNo())
      foundStudent.setName(student.getName());
      System.out.println("Student: Roll No " + student.getRollNo() + ", updated in the database");
   }
}