public interface A<T extends A<T>>{ public T b(); }

public class C implements A<C>{
  public C b() { ... }
}

public class D implements A<D>{
  public D b() { ... }
}