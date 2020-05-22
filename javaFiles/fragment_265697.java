@Configuration
@ComponentScan
public class Example {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Example.class);
        System.out.println(Arrays.toString(ctx.getEnvironment().getActiveProfiles()));
        System.out.println(ctx.getBean(Foo.class));
    }
}

@Profile(value = "StackOverflow")
@Component
class Foo {
}