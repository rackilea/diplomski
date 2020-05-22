public abstract class ArrayListGeneric1<T> {
    private int capacity = 1;
    private int size = 0;
    private T[] array = Array.newInstance(getElementType(), capacity);

    public ArrayListGeneric1() {}   

    Class<?> getElementType() {
      ParameterizedType pt = (ParameterizedType) getClass().getGenericSuperclass();
      Type[] typeArgs = pt.getActualTypeArguments();

      // Will fail if it's not a class type.
      return (Class<?>) typeArgs[0];
    }
  // ...
}