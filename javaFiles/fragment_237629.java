@ContextConfiguration(locations = "classpath:jersey-spring-applicationContext.xml")
public abstract class JerseySpringTest
{
    private JerseyTest _jerseyTest;

    public final WebTarget target(final String path)
    {
        return _jerseyTest.target(path);
    }

    @Before
    public void setup() throws Exception
    {
        _jerseyTest.setUp();
    }

    @After
    public void tearDown() throws Exception
    {
        _jerseyTest.tearDown();
    }

    @Autowired
    public void setApplicationContext(final ApplicationContext context)
    {
        _jerseyTest = new JerseyTest()
        {
            @Override
            protected Application configure()
            {
                ResourceConfig application = JerseySpringTest.this.configure();
                application.property("contextConfig", context);

                return application;
            }
        };
    }

    protected abstract ResourceConfig configure();
}