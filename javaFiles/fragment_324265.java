public class A{
   private int someMethodYouWantToTest(){}

   private Testability testability = new Testability();

   class Testability{
      int exposedMethodForTest(){
          someMethodYouWantToTest()  
      }
   }
}