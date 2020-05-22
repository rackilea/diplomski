public void testServiceCall() {
   A testedObject = new A() {
       @Override
       protected SampleService createSampleService() {
         return mockSampleService;
       }
   }
   ...
   testedObject.methodA();
   ...
   verify(service).retrieveValue();
}