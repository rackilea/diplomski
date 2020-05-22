public static void main(String[] args) {
    List<Student> students = new ArrayList<Student>();
    Scanner input = new Scanner(System.in);

    System.out.println("Enter number of students");
    int countStudents = input.nextInt();

    for(int i=0; i< countStudents; i++){
          Student student = new Student();
          System.out.println("Enter details for student"+i);

          System.out.println("Enter name");
          student.setStudentName(input.next()); 

          System.out.println("Enter Number");
          student.setStudentNo(input.next()); 

          System.out.println("Enter email");
          student.setEmail(input.next()); 

          System.out.println("Enter year");
          student.setYear(input.nextInt()); 
          students.add(student);
    }
    //Your list of students is populated now
}