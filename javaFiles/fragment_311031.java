@Configuration
@ComponentScan (
        "com.something"
)
public class Main {
    public static void main(String[] args) throws IOException {

        // Initialise spring context here, which was missing
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

 //      SecondClass cls = context.getBean(SecondClass.class);
  //     System.out.println(cls.secondMethod("something"));
       System.out.println(SecondClass.secondMethod("someString"));
    }
}