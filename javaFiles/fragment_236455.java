public Student( String fName, String lName, String maj, double gpa,number ) {
firstName = fName;
lastName = lName;
major = maj;
this.gpa = gpa;
sNumber = number;
}
private static void addStudent(ArrayList<Student> L) {
System.out.println();
Scanner input = new Scanner(System.in);
System.out.print("First name: ");
String uFName = input.nextLine();
System.out.print("Last name: ");
String uLName = input.nextLine();
System.out.print("Major: ");
String studyMaj = input.nextLine();
System.out.print("GPA: ");
double grades = input.nextDouble();
int number=0;
if(l.size()>0){
  number=l.get(l.size()-1).getSNumber()+1; 
}
Student newStudent = new Student(uFName, uLName, studyMaj, grades,number);
L.add(newStudent);
input.close();
}