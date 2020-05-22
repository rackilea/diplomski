@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:testContext.xml")
public class SomeTest extends JerseySpringTest
{
     @Autowired
     private AObject _aObject;

     @Test
     public void test()
     {
          // configure mock _aObject when(_aObject.method()).thenReturn() etc...

         Response response = target("api/method").request(MediaType.APPLICATION_JSON).get();
         Assert.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
     }

     @Override
     protected ResourceConfig configure()
     {
        return new ResourceConfig(MyResource.class);
     }
}