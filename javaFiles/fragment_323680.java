@RunWith(Enclosed.class)
public class TestClass {

    @RunWith(Parameterized.class)
    public static class TheParameterizedPart {
        @Parameter(0)
        public String key;

        @Parameter(1)
        private boolean value;

        @Parameters
        public static Object[][] data() {
            return new Object[][] {
                {"key1", true},
                {"key2", true},
                {"key3", false}
            };
        }

        @Test
        public void testKeys() {
            ...
        }

        @Test
        public void testValues() {
            ...
        }
    }

    public static class NotParameterizedPart {
        @Test
        public void testNotRelatedKeyValue() {
            ...
        }
    }
}