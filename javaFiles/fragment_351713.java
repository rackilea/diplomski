@RunWith(DataProviderRunner.class)
     class TestClassTest {
     @Mock private ExternalDependency e;
     private TestClass t;
     @Before public void setUp() { 
         MockitoAnnotations.initMocks(this); 
         t = new TestClass() {
             @Override
             protected ExternalDependency buildExternalDependency(String name, int number) {
                // validate inputs:
                Assert.assertEquals(10, number);
                Assert.assertEquals("xyz", name);
                return e;  // provide the mock      
             }    
        }
     }

     @Test public void testMethodA() {
        // TODO: mock behavior of callExternalFunction() here

            Assert.notNull(this.t.methodA()); 
    }
}