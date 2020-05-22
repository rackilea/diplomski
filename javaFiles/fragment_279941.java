public class TestController extends WithApplication {
   @Test  
   public void testSomething() {  
       Helpers.running(Helpers.fakeApplication(), () -> {  
           // put test stuff  
           // put asserts  
       });
   }