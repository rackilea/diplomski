public class Address{

         private static Employee employee;

         @Autowired
         private Employee employeeI;

         @PostConstruct
         public void init() {
           Address.employee= employeeI;
         }

          public static void display(){
            employee.name;
          }
     }