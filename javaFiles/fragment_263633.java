import static java.lang.System.out;
class Employee  {
     // class level counter. It exist regardless of the instances created.
     public static int employeeCount = 0;
     // instance attribute. Each one is different from others instances
     private String employeeName;

     // Class level method, can be invoked without instance.
     public static Employee createEmployee( String withName ) {

         Employee e = new Employee();
         // Set the name to the instance
         e.employeeName = withName;
         // Increments the class counter
         Employee.employeeCount++;
         return e;
     }
     // Object constructor.
     public Employee() {
          out.println("Constructor invoked!!! A new object has born, yeah!");
     }
     // Instance method "toString()"
     public String toString() {
         // Uses "this" to refer instance level method
         return this.emploeeName;
     }

     // Test
     public static void main( String [] args ) {

          // The counter already exist
          out.printf("Employees created %d%n", Employee.employeeCount );
          // Create employee a
          Employee a = Employee.createEmployee("Oscar");
          // Its name now exists 
          out.printf("Employee name: %s %nEmployees created %d%n",
                      a.employeeName,  Employee.employeeCount );
          // Create employee b with a new name 
          Employee b = Employee.createEmployee("HH");
          out.printf("Employee name: %s %nEmployees created %d%n", 
                      b.employeeName,  Employee.employeeCount );
          // Now both employees exist, each one with a name 
          out.printf("a=%s, b=%s%n, a, b );// invoke toString method which in turn uses "this"

     }
}