public class NameMatcher implements IArgumentMatcher {
    private Object expected;

    public NameMatcher(Object expected) {
        this.expected = expected;
    }

    @Override
    public void appendTo(StringBuffer buffer) {
        buffer.appendTo("Name is \"" + expected.getName() + "\"");
    }

    @Override
    public boolean matches(Object actual) {
        return expected.getName().equals(actual.getName());
    }
}