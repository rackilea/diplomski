import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");  

        //AutoWire By @annotation
        Tiger tiger = (Tiger) context.getBean("tigerBean");
        System.out.println(tiger.toString());
    }

}