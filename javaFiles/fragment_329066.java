public class Methods {
  public static boolean isInvocable(Method method, Object instance,
      Object... arguments) {
    return correctInstance(instance, method)
        && correctArguments(arguments, method);
  }

  private static boolean correctInstance(Object instance, Method method) {
    return Modifier.isStatic(method.getModifiers())
        || method.getDeclaringClass().isInstance(instance);
  }

  private static boolean correctArguments(Object[] arguments, Method method) {
    Class<?>[] parameters = method.getParameterTypes();
    if (parameters.length != arguments.length) {
      return false;
    }
    for (int i = 0; i < parameters.length; i++) {
      if (!correctArgument(arguments[i], parameters[i])) {
        return false;
      }
    }
    return true;
  }

  private static boolean correctArgument(Object instance, Class<?> type) {
    return type.isPrimitive()
        ? correctPrimitive(instance, type)
        : instance == null || type.isAssignableFrom(instance.getClass());
  }

  private static boolean correctPrimitive(Object argument, Class<?> type) {
    try {
      Method method = Overloading.class.getDeclaredMethod("method", type);
      method.setAccessible(true);
      method.invoke(null, argument);
      return true;
    } catch (IllegalArgumentException e) {
      return false;
    } catch (NoSuchMethodException e) {
      throw new Error(e);
    } catch (IllegalAccessException e) {
      throw new Error(e);
    } catch (InvocationTargetException e) {
      throw new Error(e);
    }
  }

  @SuppressWarnings("unused")
  private static class Overloading {
    private static void method(byte argument) {}

    private static void method(short argument) {}

    private static void method(int argument) {}

    private static void method(long argument) {}

    private static void method(float argument) {}

    private static void method(double argument) {}

    private static void method(boolean argument) {}

    private static void method(char argument) {}
  }
}