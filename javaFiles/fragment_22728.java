public class SuperClass<T extends SuperClass<T>> {
    private String name;

    public T setName(String name) {
      this.name = name;
      return (T) this;
    }
}