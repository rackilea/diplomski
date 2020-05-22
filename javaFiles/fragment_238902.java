new MockUp<SomeOtherClass>() {
    @Mock
    public void processTask(String value, List<Map<String, String>> mappings) throws Exception {
        System.out.println("Hello World");
    }
};