@SuppressWarnings({ "unchecked", "rawtypes" })
public static<T> Comparator<T> 
  newMethodComparator(Class<T> cls, String methodName) throws Exception {    
  Method method = cls.getMethod(methodName);
  if (method.getParameterTypes().length != 0) 
    throw new Exception("Method " + method + " takes parameters");

  Class<?> returnType = method.getReturnType();
  if (!Comparable.class.isAssignableFrom(returnType))
    throw new Exception("The return type " + returnType + " is not Comparable");

  return newMethodComparator(method, (Class<? extends Comparable>) returnType);      
}

private static<T,R extends Comparable<R>> Comparator<T> newMethodComparator(
    final Method method, final Class<R> returnType) throws Exception {    
  return new Comparator<T>() {
    @Override
    public int compare(T o1, T o2) {
      try {
        R a = invoke(method, o1);
        R b = invoke(method, o2);
        return a.compareTo(b);
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    private R invoke(Method method, T o) throws Exception {
      return returnType.cast(method.invoke(o));
    }
  };
}