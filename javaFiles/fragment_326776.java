public class Student{ // created class
String studentName; // DataMember or Instance variable
int age;
int rollNo;
// creating insertRecord method
void insertRecord(int age,String name,int rollno){ 
this.age=age;
studentName=name;
rollNo=rollno;  
}
void displayRecord(){
System.out.println(age+""+studentName+""+rollNo);
}
public static void main(String[] args){ // main method
Student s1=new Student(); // creating object
Student s2=new Student(); // creating object

s1.insertRecord(23,"Meena",101);
s2.insertRecord(24,"Nisha",102);
s1.displayRecord();
s2.displayRecord();

}
}