when(mock.resolveVariable(anyObject(), anyString())).thenAnswer(new Answer<String>() {
    @Override
    public String answer(InvocationOnMock invocation) throws Throwable {
        Object[] args = invocation.getArguments();
        String secondArgument = (String) args[1];
        //
        // TODO: make return value depend from secondArgument
        return null;
    }
});