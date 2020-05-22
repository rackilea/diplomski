public class Student {

    private String studentMajor;
    private String studentName;

    public Student(String major, String name) {
        this.studentMajor = major;
        this.studentName = name;
    }

    public Student(Scanner kb) {
        System.out.println("Please insert the student's name.");
        this.studentName = kb.nextLine();
        System.out.println("Please insert the student's major.");
        this.studentMajor = kb.nextLine();
    }

    // Add getter for your fields here.

    @Override
    public String toString(){
        return studentName +": "+ studentMajor+"\n";
    }

}