public class Settable<T> {

  private boolean isSet = false;
  private T value;

  public Settable() {}

  public boolean isSet() {return isSet;}
  public T value() { return value;}
  public void set(T t) { value = t; isSet = true;}
}