public class MyClass<T> {
   T myItem;

   public void myMethod(T item) {
      // do Something with item
   }

   public T myOtherMethod() {
      myMethod(myItem);   // casting is not necessary
      return myItem;
   }

}