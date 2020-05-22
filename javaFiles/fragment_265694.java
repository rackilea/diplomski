@Configuration
public class Example {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Example.class);
        ctx.getBean(Foo.class);
    }
}

class Foo {}