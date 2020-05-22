public class Demo {
  private String work(String s) {
    return s.toUpperCase();
  }

  private Boolean work(Boolean b) {
    return !b;
  }

  public <T> T test(T t) {
    // common work to do !!
    // .....

    // Now look-up "work" method for type T. Invoke if defined.
    T result = null;
    try {
      Class<T> tType = (Class<T>) t.getClass();
      Method work = Demo.class.getDeclaredMethod("work", tType);
      if (work.getReturnType() != tType) {
        throw new NoSuchMethodException("No `work` method for type: " + tType);
      }

      result = (T) work.invoke(this, t);
    } catch (NoSuchMethodException e) {
      // NOOP - or whatever.
    } catch (IllegalAccessException | InvocationTargetException e) {
      // Method invocation failed. Handle properly.
      e.printStackTrace();
    }

    return result;
  }
}