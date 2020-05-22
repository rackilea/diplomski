@SpringBootTest
@ExtendWith(SpringExtension.class)
class MyNestedTest {

    @BeforeAll
    void setup() {
        // General test-suite setup
    }

    @Nested
    @DisplayName("parentTestSuite")
    class NestedClass {

        @Test
        void testSomething() {
            // Test
        }

        @Nested
        @DisplayName("childTestSuite")
        class AnotherNestedClass {

            @Test
            void testSomethingElse() {
                // Test
            }

        }
    }
}