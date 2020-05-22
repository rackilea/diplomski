public class MyTest{
   public MyTest(){
      // called n times
      System.out.println("Constructor called for MyTest");
   }

   @Before //called n times
   public void setUp(){
      System.out.println("Before called for MyTest");
   }

   //n test methods
}