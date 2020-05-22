@RunWith(SpringRunner.class)
@EnableConfigurationProperties
@ContextHierarchy({
        @ContextConfiguration(classes = TestConfiguration.class,
                       initializers = TestContextInitializer.class),
        @ContextConfiguration(classes = TestOneConfiguration.class)
})

public class TestOne {

    @Autowired
    HelloWorld helloWorld;

    @Test
    public void test () {

    }
}