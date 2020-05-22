@RunWith(HierarchicalContextRunner.class)
public class NestedTest {

    @ClassRule
    public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();

    @Rule
    public final SpringMethodRule  springMethodRule = new SpringMethodRule();

    @Before
    public void setup() {
        // General test-suite setup
    }

    public class NestedClass {

        @Test
        public void testSomething() {
            // Test
        }

        public class AnotherNestedClass {

            @Test
            public void testSomethingElse() {
                // Test
            }
        }
    }
}