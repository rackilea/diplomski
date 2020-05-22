@RunWith(SpringJUnit4ClassRunner.class)
@Profile("test")
@ContextConfiguration(classes = {ApiConfiguration.class, MyControllerTest.MyConfig.class})
public class MyControllerTest {

 @Autowired 
 ExternalService externalService;

  @Test public void test() {
     ...
  }

  @Configuration
  public static class MyConfig {
     @Bean 
     @Primary // it tells Spring DI to select your mock instead of your real ExternalService impl
     public ExternalService mockExternalService() {
         return Mockito.mock(ExternalService.class);
     }     
  }
}