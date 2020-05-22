@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class,webEnvironment = 
                           WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = MyIntegrationTest.Initializer.class)
public class MyIntegrationTest {

public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        TestPropertyValues values = TestPropertyValues.of(
                "some.value.1=" + someObject.getSomeValue(),
                "some.value.2=" + someObject.getOtherValue()
        );
        values.applyTo(configurableApplicationContext);
    }
  }
}