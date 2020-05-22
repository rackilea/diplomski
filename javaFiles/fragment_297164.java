public class Address{

      private static Employee employee;

      @Autowired
      public Address(Employee employee){
        Address.employee= employee;
      }

      public static void display(){
        employee.name;
      }
 }