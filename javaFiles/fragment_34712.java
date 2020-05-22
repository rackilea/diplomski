@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestApplication.class, 
    initializers = ConfigFileApplicationContextInitializer.class)
public class SomeTestClass {
    ...
}