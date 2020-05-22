public class MySubClass extends MyClass{

    public MyClass filterOn(String something){
       MySubClass result = new MySubClass();
       result.doSomethingUsingThisInstance(this, something);
       return result;
    }
   ....
 }