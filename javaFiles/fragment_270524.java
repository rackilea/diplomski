@ContextConfiguration(
  initializers = ConfigFileApplicationContextInitializer.class,
  classes = {SomeApp.class})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class SomeIntegrationTest {

  @Test
  public void testTheIntegration() {
    // some integration tests here
  }
}