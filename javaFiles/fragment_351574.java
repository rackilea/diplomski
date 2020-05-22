class Employee
{
   protected int empID;
   protected String name;
   public Employee(int empID,String name)
   {
     this.empID = empID;
     this.name = name;
   }
}

class Manager extends Employee
{
  private String salary;
  private int deptID;
  public Manager(String salary, int deptID,int id, String name)
  {
    super(id,name);
    this.salary = salary;
    this.deptID = deptID;

    // Can access protected variables
    empID = 0;
  }
 }