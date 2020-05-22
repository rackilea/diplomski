public class MyObjectWrapper { 
   private MyInterface myObject;

   public MyObjectWrapper (MyInterface myObject) {
       this.myObject = myObject;
   }

   public myMethod(int param) {
     this.myObject.myMethod(param);
   }
}