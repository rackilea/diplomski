public static void main(String[] args){
   ArrayList<Student> students = new ArrayList<Student>();
   Scanner oScan = new Scanner(System.in);
   System.out.println("Enter the number of students");

   int numberOfStudents = oScan.nextInt();

    for(int i = 0;i < numberOfStudents;i++){
    System.out.println("Enter First Name");
   String fn = oScan.nextLine();
    System.out.println(fn);

    System.out.println("Enter Last Name");
    String ln = oScan.nextLine();
    System.out.println(ln);

   //Add all the score stuff
 Student s = new Student(homeworkAve,quizAve,projectAve, testAve,fn,ln);
    students.add(s);
  }
}