@RunWith(Parameterized.class)
 @ContextConfiguration(classes = {ApplicationConfigTest.class})
 public class ServiceTest {

     private TestContextManager testContextManager;

     @Before
     public void setUpContext() throws Exception {
         //this is where the magic happens, we actually do "by hand" what the spring runner would do for us,
        // read the JavaDoc for the class bellow to know exactly what it does, the method names are quite accurate though
       this.testContextManager = new TestContextManager(getClass());
       this.testContextManager.prepareTestInstance(this);
     }
     ...
 }