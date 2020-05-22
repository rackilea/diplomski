@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring/applicationContext.xml" })
public class ServiceThatNeedsServiceInterfaceTest {

    @Autowired
    ServiceThatNeedsServiceInterface serviceThatNeedsServiceInterface;

    @Test
    public void testUseService() {
    //As we are not running from a web container
    //so we set the context directly to the service 
        RequestContext context = new RequestContext();
        context.setQualifier("ProductAService");
        serviceThatNeedsServiceInterface.context = context;
        serviceThatNeedsServiceInterface.useService();

        context.setQualifier("ProductBService");
        serviceThatNeedsServiceInterface.context = context;
        serviceThatNeedsServiceInterface.useService();
    }

}