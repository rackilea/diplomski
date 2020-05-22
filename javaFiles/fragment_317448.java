when(mock.testMethod(anyString())).thenAnswer(new Answer<String>() {
    @Override
    public String answer(InvocationOnMock invocation) {
        return invocation.getArgumentAt(0, String.class);
    }
});