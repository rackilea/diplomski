public class Bar<T extends A & B> implements Foo<Collection<T>>{
  @Override
  public boolean apply(Collection<T> collect){
   ...
  }  
}