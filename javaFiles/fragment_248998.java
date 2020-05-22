public class MainApp {
     public static void main(String[] args) {
         ApplicationContext context =
         new ClassPathXmlApplicationContext("Beans.xml");

         StudentJDBCTemplate studentJDBCTemplate =
  (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");

         System.out.println("------Listing Multiple Records--------" );
         List<String> studentsName = studentJDBCTemplate.listStudentsNames();
         for (String name : studentsName) {
              System.out.println("Name : " + name);
         }

     }
 }