class CustomAnswer extends Answer<Integer> {

    private boolean first = true;

    @Override
    public Integer answer(InvocationOnMock invocation) {
        if (first) {
            first = false;
            throw new SQLException("I have failed.");
        }
        return 1;
    }
}