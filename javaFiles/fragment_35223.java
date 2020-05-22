when(someMock.someMethod()).thenAnswer(new Answer() {
    private int count = 0;

    public Object answer(InvocationOnMock invocation) {
        if (count++ == 1)
            return 1;

        return 2;
    }
});