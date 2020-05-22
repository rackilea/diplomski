import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Function;

public class Play {
  public int hello() {
    return 5;
  }

  static public int byebye() {
    return -1;
  }

  public static class ExtendedPlay extends Play {
    @Override
    public int hello() {
      return 10;
    }
  }

  private static <T> Function<T,Integer> getFunction(Class<T> clazz,String method) throws NoSuchMethodException {
    Method m = clazz.getDeclaredMethod(method);
    return (o)->{
      try {
        return ((Integer)m.invoke(o));
      } catch (IllegalAccessException | InvocationTargetException ex) {
        // Just hope and pray this will be all ok!
      }
      return 0;
    };
  }

  private static <T> Function<Class<T>,Integer> getStaticFunction(Class<T> clazz,String method) throws NoSuchMethodException {
    Method m = clazz.getDeclaredMethod(method);
    return (o)->{
      try {
        return ((Integer)m.invoke(o));
      } catch (IllegalAccessException | InvocationTargetException ex) {
        // Just hope and pray this will be all ok!
      }
      return 0;
    };
  }

  private static Function<Object,Integer> getFunction(String method) {
    return (o)->{
      try {
        Method m;
        if (o instanceof Class) // For static methods
          m = ((Class)o).getDeclaredMethod(method);
        else // For instance methods
          m = o.getClass().getDeclaredMethod(method);
        return ((Integer)m.invoke(o));
      } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException ex) {
        // Just hope and pray this will be all ok!
      }
      return 0;
    };
  }

  public static void main(String args[]) throws NoSuchMethodException {
    // Little quicker because class type and Method instance can be resolved before multiple executions.
    // Method is cached and has better compile-time type checking, but requires extra paramter.
    Function<Play,Integer> f1 = getFunction(Play.class,"hello");
    Function<Class<Play>,Integer> f2 = getStaticFunction(Play.class,"byebye");

    // Little slower, because method instance has to be resolved for each subsequent call
    // of the dereferenced Function Object. Slower but use is simpler: one less parameter, and works for 
    // both static and instance methods.
    Function<Object,Integer> f3 = getFunction("hello");

    System.out.println("Value1 is: "+f1.apply(new ExtendedPlay()));
    System.out.println("Value2 is: "+f2.apply(Play.class));
    System.out.println("Value3 is: "+f3.apply(new Play()));
  }
}