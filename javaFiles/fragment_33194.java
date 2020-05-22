class A {
    public String methodA() {
        SampleService service = createSampleService();
        return service.retrieveValue();
    }

   protected SampleService createSampleService() {
     return new SampleService();
   }
}