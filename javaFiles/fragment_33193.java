class A {
    private SampleServiceFactory factory;
    public String methodA() {
        SampleService service = factory.createSampleService();
        return service.retrieveValue();
    }
}