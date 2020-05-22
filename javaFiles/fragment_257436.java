public class MySubClass extends MyClass{
   @Test
   public void testSomethingElse(){
       super.customTest(new MyCustomTest()); 
   } 
}