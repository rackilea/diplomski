@Component
public class Main
{
    @Autowired
    protected MyDependencyClass2 someClass1;
    @Autowired
    protected MyDependencyClass2 someClass2;
    // ...
    // or if you need an entity manager
    @PersistenceContext
    protected EntityManager em;
    // etc.

    protected void mainInternal(String[] args)
        throws Exception
    {
        // do everything here
        // all dependencies are initialized
        // ...
    }

    public static void main(String[] args)
        throws Exception
{
        // Bootstrap Spring and let it create and configure beans.
        final ApplicationContext context =
            new ClassPathXmlApplicationContext("spring-context.xml");
        context.getBean(Main.class).mainInternal(args);
    }
}