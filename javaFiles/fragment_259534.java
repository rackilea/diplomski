@ContextConfiguration
public class RealTest extends AbstractTest {

    @Autowired
    private ApplicationContext appCtx;

    private Service service;

    @Before
    public void setUp() {
        AnnotationConfigApplicationContext testCtx = new AnnotationConfigApplicationContext();
        testCtx.setParent(this.appCtx);
        testCtx.register(RealTestCfg.class);
        testCtx.refresh();

        this.service = BeanFactoryUtils.beanOfType(testCtx, Service.class);
    }

    @Configuration
    public static class RealTestCfg {

        @Bean
        public Session session() {
            return AbstractTest.session;
        }

        @Bean
        public Service service() {
            return new Service();
        }
    }
}