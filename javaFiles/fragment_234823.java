public abstract class AbstractTest {

private static SessionFactory sf;

@Autowired
public void setSessionFactory (SessionFactory sf){
    AbstractTest.sf = sf;
    setup();
}

//@BeforeClass
public static void setup() {
    sf.getCurrentSession().createQuery("make tables");
}
}