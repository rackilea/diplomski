import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SpringTest {
    @Autowired
    Person person;

    public static void main(String[] args) {
        generalTest();
    }

    private static void generalTest() {
        testApplicationContext();
    }

    private static void testApplicationContext() {
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("C:\\E_Drive\\Projects\\Workspace\\Test\\CS101\\src\\com\\learn\\stackoverflow\\general\\bean.xml");
        SpringTest springTest = (SpringTest) applicationContext.getBean("springTest");

        if(springTest.person == null){
            System.out.println("person is NULL");
        } else{
            System.out.println("person is not NULL");
            springTest.person.sayHello(); // here output will be “Hello, ppj” if you keep the config file bean definition and when you remove that bean definition then output is “Hello, null”
        }

    }
}