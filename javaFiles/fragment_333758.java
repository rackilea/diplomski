final AtomicInteger count = new AtomicInteger(0);
PowerMockito.whenNew(HashMap.class).withNoArguments()
    .thenAnswer(new Answer<HashMap<String, String>>() {

    @Override
    public HashMap<String, String> answer(InvocationOnMock invocation) throws Throwable {
        count.incrementAndGet();
        switch (count.get()) {
            case 1: // first call, return normalMap
                return normalMap;
            case 2: // second call, return mockMap
                return mockMap;
            case 3: // third call, return normalMap2
                return normalMap2;
            default: // forth call (and all calls after that), return normalMap3
                return normalMap3;
        }
    }
});