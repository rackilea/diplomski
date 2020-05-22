public class readStudent
{
       public static List<Student> studentList = new ArrayList<Student>();

       public static void main(String[] args) {
           readStudent(); //to initialize studentList
           //other methods here
       }

       public static void readStudent() throws Exception {
       Scanner input = new Scanner(new File("students.txt")); 

       while (input.hasNext()) {

            int id = input.nextInt();
            String lastName = input.next();
            String firstName = input.next();            
            int gradYear = input.nextInt();

            Student student = new Student(id, firstName, lastName, gradYear);
            studentList.add(student);
        }

    }
}