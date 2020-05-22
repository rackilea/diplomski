@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ContextConfiguration.class)
@DirtiesContext
public abstract class MyTests {

    @SpringBootApplication
    @Import(BigIntegrationConfiguration.class)
    public static class ContextConfiguration {

    }

}