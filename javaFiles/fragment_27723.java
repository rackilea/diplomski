public class JavaMainTest {

public static void main(String[] args) {

Employee myEmp  = new Employee("William", "Russell", 30000d);
Employee myEmp2  = new Employee("Yevgeniya", "Pakhom", null);
Employee myEmp3  = new Employee("Sernea", "Monsen", -1d);
myEmp.displayMessage();
myEmp2.displayMessage();
myEmp3.displayMessage();
}
}



 class Employee {

    private String fName;
    private String lName;
    private Double ySalary;

public Employee (String firstName, String lastName, Double yearSalary)
    {
        fName = firstName;
        lName = lastName;
        if (yearSalary!=null)
        ySalary = yearSalary;
    }
// Set First Name
    public void setFName (String firstName)
        {
        fName = firstName;
        }
// Get First Name
    public String getFName()
        {
        return fName;
        } 

   // Set Last Name
    public void setLName (String lastName)
        {
        lName = lastName;
        }
  //  Get Last Name
    public  String getLName()
        {
        return lName;
        } 

 // Set Salary
    public void setSalary (Double yearSalary)
        {

            ySalary = yearSalary;

        }
// Get Salary
    public Double getYearSalary()
        {

        return ySalary;

        }
// Display method
        public void displayMessage()
        {
            if (ySalary == null)
                 System.out.printf("Hello %s %s, \nI see you're       currently making: %.6f\n", getFName(), getLName(),getYearSalary() );
            else if (ySalary < 0)
                 System.out.printf("Hello %s %s, \nI see you're       currently making: %.2f\n", getFName(), getLName(),getYearSalary() );


 }
}