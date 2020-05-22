public abstract class MyClass{
   @Autowired
   Object implicitObject;

   @Test
   public void commonTest(){
        implicitObject.doSomethingBasic();
   } 
}

public class MySubClass extends MyClass{
   @Test
   @Autowired
   public void testSomethingElse(Object injectedImplicitObject) {
         injectedImplicitObject.doSomethingElse(); 
   } 
}