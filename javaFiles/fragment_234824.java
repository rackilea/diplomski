@TestExecutionListeners(listeners = {AbstractTest.class, DependencyInjectionTestExecutionListener.class})
public class AbstractTest extends AbstractTestExecutionListener {

public static SessionFactory sf;

@BeforeClass
public static void setup() {
    sf.getCurrentSession().createQuery("make tables");
}

@Override
public void beforeTestClass(TestContext testContext) throws Exception {
    sf = testContext.getApplicationContext().getBean(SessionFactory.class);
    super.beforeTestClass(testContext);
}
}