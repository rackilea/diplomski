private class MyVarargMatcher extends ArgumentMatcher<Object[]> implements VarargMatcher {
    private Object[] expectedValues;

    MyVarargMatcher(Object... expectedValues) {
        this.expectedValues = expectedValues;
    }

    @Override
    public boolean matches(Object varargArgument) {
        return new EqualsBuilder()
        .append(expectedValues, varargArgument)
        .isEquals();
    }
}