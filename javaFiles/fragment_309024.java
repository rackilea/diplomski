public abstract class Service<T> {
   MyGenericClass<T> generic;

   public MyGenericClass (MyGenericClass<T> generic){
       this.generic = generic;
   }
}