public class ApplicationContextTest extends TestCase {

  protected ApplicationContext      ctx;

  protected static final String[]   CONTEXT_LOCATIONS = new String[] {
      "classpath:resources/applicationContext.xml"};

  public void setUp() throws Exception {
    super.setUp();
    ctx = new ClassPathXmlApplicationContext(CONTEXT_LOCATIONS);
  }

  public void test() {
    ChildAction ca = ctx.getBean("childAction", ChildAction.class);
    assertNotNull(ca.getTypeToURLMap());
  }
}