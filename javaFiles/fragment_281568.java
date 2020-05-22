import java.util.Scanner;
     public class student_tester {

public static void main (String [] args) {
 List<Student> allStudents =new ArrayList<Student>();
Scanner in = new Scanner(System.in);

while(true){
    Student student01 = new Student ();
  System.out.println("Please enter the students name");
    student01.setName(in.nextLine());
  System.out.println("Please enter the students address");
    student01.setAddress(in.nextLine());
  System.out.println("Please enter the students DOB"); 
    student01.setDob(in.nextLine());

 System.out.println("Please enter the students gender"); 
    student01.setGender(in.nextLine());
}
}