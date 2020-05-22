public class Student {
       // Data Members
    private String name;
    private int idNumber;
    private List<Integer> examResults;

    // Constructor
    public Student() {
        name = "Unassigned";
        idNumber = 0;
        examResults = new ArrayList<Integer>(5);
    }

    // Getters
    public String getName(){
        return name;
    }   

    public int getIdNumber(){
        return idNumber;
    }

    public void addResult(Integer result){
        examResults.add(result);
    }

    // Setters
    public void setName(String name){
        this.name = name;
    }

    public void setIdNumber(int idNumber){
        this.idNumber = idNumber;
    }

    // Calculate Result 
    protected Integer calculateResult() {

        Integer total = 0;

        for(Integer result : examResults){
            total += result;
        }

        return total / examResults.size();
    }

    public void showResultText(){
        Integer result = calculateResult();

        // Check if Student passed or failed
        if (result < 0) {
            System.out.println("Overall Result: " + result + " (Fail)");
        } else {
            System.out.println("Overall Result: " + result + " (Pass)");
        }
    }
}

public class Undergraduate extends Student {
    @Override
    public void showResultText() {

        Integer result = calculateResult();

        if (result < 50) {
            System.out.println("Overall Result: " + result + " (Fail)");
        } else {
            System.out.println("Overall Result: " + result + " (Pass)");
        }
    }
}

public class Postgraduate extends Student {
    @Override
    public void showResultText() {

        Integer result = calculateResult();

        if (result < 40) {
            System.out.println("Overall Result: " + result + " (Fail)");
        } else {
            System.out.println("Overall Result: " + result + " (Pass)");
        }
    }
}

public class StudentTest {
    public static void main(String [] args){

        // Declaration & Creation of Scanner object
        Scanner input = new Scanner(System.in);

        // Create Array of Undergrad and Postgrad Students
        Student[] students = new Student[5];
        students[0] = new Undergraduate();
        students[1] = new Postgraduate();
        students[2] = new Undergraduate();
        students[3] = new Postgraduate();
        students[4] = new Undergraduate();


        // Get Input for Name 
        for (Student student :  students) {
            System.out.println();
            System.out.print("Enter Student Name: ");
            student.setName(input.nextLine());

            // Get Input for Id Number
            System.out.print("Enter Student ID Number: ");
            student.setIdNumber(input.nextInt());
            input.nextLine();

            // Initialise Variables
            int examsEntered = 0;

            // Get Input for Exam Result and add to total
            while (examsEntered < 5) {
                System.out.print("Enter Exam Result (0-100): ");
                Integer result = input.nextInt();
                input.nextLine();
                if (result >= 0 && result <= 100) {
                    student.addResult(result);
                    examsEntered++;                    
                } else {
                    System.out.println("Please Enter a Valid Number 0-100");
                }
            }
        }

        for (Student student :  students) {
        // Display Student Info and Results
            System.out.println();
            System.out.println("Student Name: " + student.getName());
            System.out.println("Student ID: " + student.getIdNumber());
            student.showResultText();
            System.out.println();
        }

    } // end main
}