class AddingAnswer implements Answer {
    int current = 0;
    public Object answer(InvocationOnMock invocation) {
        int result = current;
        current += 100;
        return result;
    }
}