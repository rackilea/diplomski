@ClassRule
public static ExternalResource setProperties() {
    return new ExternalResource() {
        @Override
        public Statement apply(Statement base, Description description) {
            System.setProperty("sample.property", "hello world!");
            return super.apply(base, description);
        }
    };
}