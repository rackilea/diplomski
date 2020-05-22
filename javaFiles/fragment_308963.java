public class MyClass {

   public MyClass(){
     }

   public MyClass createSpecificInstance() {
     return new MyClass();
   }

   public MyClass filterOn(String something){
       MyClass result = createSpecificInstance();
       result.doSomethingUsingThisInstance(this, something);

      return result;
   }

}