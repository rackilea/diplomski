@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
    TestPreperationExecutionListener.class
    })
@Transactional
@ActiveProfiles(profiles = "localtest")
@ContextConfiguration
public class TestContext {

  @Test
  public void testContext(){

  }

  @Configuration
  @PropertySource("classpath:/myprops.properties")
  @ImportResource({"classpath:context.xml" })
  public static class MyContextConfiguration{

  }
}