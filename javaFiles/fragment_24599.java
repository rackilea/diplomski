@RunWith(CdiRunner.class)
@AdditionalClasses({ValueProducerTest.ValueProducer.class})
public class ValueProducerTest {

    @Inject
    @ConfigurationValue
    private String testValue;

    @Test
    public void test() {
        assertEquals(testValue, "Test");
    }

    public static class ValueProducer {
        @Produces
        @ConfigurationValue
        public String getStringConfigValue(InjectionPoint ip) {
            return "Test";
        }
    }

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD, ElementType.FIELD})
    public static @interface ConfigurationValue {}
}