public class Salary
    {
       protected Integer id;
       protected Boolean simulated;
       protected Double salary;

    }

public class Simulation extends Salary
{
 //you do not need Integer id here
 private Double simulatedSalary;
 private Double notsimulatedSalary;
 private Double totalSalary;
}