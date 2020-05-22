public class Foo<T> {
   T data;

   public Foo(T d)
   {
      this.data = d;
   }

   public T getData()
   {
     return data;
   }
}