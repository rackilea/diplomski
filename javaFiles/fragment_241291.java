public class YamlTestDataFile {
    public static final class Test {
        private String className;
        public String param;
        public String value;

        public String getClass() { return className; }
        public void setClass(final String value) { className = value; }
    }

    private List<Test> tests;

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }
}