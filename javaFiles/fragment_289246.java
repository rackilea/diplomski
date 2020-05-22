abstract class FooFactory<T extends FooFactory<T>> {
  private Date date;

  public abstract T getThis();

  public T withDate(Date date) {
    this.date = date;
    return getThis();
  }