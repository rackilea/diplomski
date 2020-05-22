PowerMockito.whenNew(HashMap.class).withNoArguments()
    .thenAnswer(new Answer<HashMap<String, String>>() {

    @Override
    public HashMap<String, String> answer(InvocationOnMock invocation) throws Throwable {
        count.incrementAndGet();
        if (count.get() == 2) { // second call
            return mockMap;
        }
        return normalMap; // don't forget to make normalMap "final"
        // or if you prefer: return new HashMap<String, String>();
    }
});