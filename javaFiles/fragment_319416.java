abstract class Test<T extends Test<T>> {
     @SuppressWarnings("unchecked")
     public T setField()
     {
         return (T)this;
     }
}