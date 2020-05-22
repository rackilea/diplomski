import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.Test;

public class Main {
    public static void main(final String[] args) throws Exception {
        final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("test.xml");
        final Test test = ctx.getBean(Test.class);
        test.print("Hello");
    }
}