public abstract class Builder<T extends A> {
  public T build(*?*){
    //compute args
    return create(args);
  }

  protected abstract T create(args);
}

public class B_Builder extends Builder<B> {
  @Override
  protected B create(args) {
    return new B(args);
  }
}

public class C_Builder extends Builder<C>{
  @Override
  protected C create(args) {
    return new C(args);
  }
}