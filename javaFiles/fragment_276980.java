public class MyClass {

     @Autowired
     private java.util.Properties properties;


     public void myMethod() {
         String a = properties.getProperty("a");
         String b = properties.getProperty("b");
         String c = properties.getProperty("c");
     }
}