public class Employee implements Comparable<Employee> {

   private int empSalary;
   private String empName;

   @Override
   public int compareTo(Employee e) {
       int cmp = this.empName.compareTo(e.empName);
       return cmp != 0 ? cmp : Integer.compare(empSalary, e.empSalary);
   }

}