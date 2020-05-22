@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={
    MyClass1.class,
    Myclass2.class,
    MyJaxRsResource.class,
    MockServletContextAwareProcessor.class,
    MyCTest.Config.class
})
public class MyCTest
{
    @Configuration
    static class Config 
    {
          // Set up and register mocks here, and watch them be autowired!
          @Bean public DBService dbJobService() throws DBException
            {
                return mock(DBService.class); 
            }
    }

    @Autowired MyJaxRsResource myResource;

    @Test public void test() {
         String response = myResource.get("hello");
    }
}