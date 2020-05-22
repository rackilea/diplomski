public class MyClass{

   @Autowired
   private Object implicitObject;

   @Test
   public void commonTest(){
        implicitObject.doSomethingBasic();
   }

   /**
    * method that accept the visitor and give access to implicitObject
    */
   public final void customTest(CustomTest customTest) {
       // You can prepare some stuff before
       customTest.test(implicitObject);
       // You can cleanup after
   }
}