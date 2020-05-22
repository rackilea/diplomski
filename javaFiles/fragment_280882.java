public class Hat<T>
{
  private final Class<? extends T> expectedClass;

  public Hat(Class<? extends T> expectedClass)
  {
    this.expectedClass = expectedClass;
  }

  public ArrayList<T> convert(String s)
  {
    T t = expectedClass.cast(s);  // This cast will fail at runtime if T isn't String

    ArrayList<T> list = new ArrayList<T>();
    list.add(t);
    return list;
  }
}