import org.springframework.context.*;
import org.springframework.context.support.*;

public class SomeJob {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyBean myBean = (MyBean) ctx.getBean("myBean");
        myBean.someMethod();
    }

}