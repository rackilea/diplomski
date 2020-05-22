@Configuration
@ComponentScan
public class Example {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Example.class);
    }
}

@Component
class Foo { @Autowired Bar bar; }
class Bar { }