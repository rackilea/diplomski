Answer<String> answer = new Answer<String>() {
    public String answer(InvocationOnMock invocation) throws Throwable {
        Long long = invocation.getArgumentAt(0, Long.class);
        return long + " entries";
    }
};


when(mockedObject.printEntries(anyLong()).thenAnswer(answer);