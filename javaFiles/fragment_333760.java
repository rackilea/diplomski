PowerMockito.whenNew(HashMap.class).withNoArguments()
    .thenAnswer(new Answer<HashMap<String, String>>() {

    private int count = 0;

    @Override
    public HashMap<String, String> answer(InvocationOnMock invocation) throws Throwable {
        count++;
        if (count == 2) { // second call
            return mockMap;
        }

        return normalMap; // don't forget to make normalMap "final"
        // or if you prefer: return new HashMap<String, String>();
    }
});