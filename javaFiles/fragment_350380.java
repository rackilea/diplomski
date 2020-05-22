public class Employee {

    // instance
    private String firstName;
    private String lastName;
    private int empID;

    // global
    private static int empIDinc = 0;

    // constructor
    public Employee(String first, String last){

        // local to this instance
        this.firstName = first;
        this.lastName = last;

        // global across all employees
        empIDinc ++;
        empID = empIDinc;
        }

    public String toString() {
        // added employee ID to string
        return firstName + ' ' + lastName + " ID: " + Integer.toString(empID);
    }
}