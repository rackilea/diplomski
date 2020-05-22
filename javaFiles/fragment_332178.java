public class CommonTestSuite {

    private final Source source;

    public CommonTestSuite(Source source) {
         this.source = source;
    }

    public Collection<DynamicTest> tests() {

        return Arrays.asList(
            dynamicTest("Should return only lowercase.", this::testLowercase),
            dynamicTest("Should return only one letter.", this::testLength)
        );

    }

    void testLowercase() {
         assert(source.read().equals(source.read().toLowerCase()));
    }

    void testLength() {
         assert(source.read().size() == 1);
    }
}