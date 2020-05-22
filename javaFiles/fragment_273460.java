public class Foo<T> {

  public <E> Map<T, E> convertIterableToMap(Iterable<E> iterable) {
    return null;
  }

  public static void main(String[] args) throws Exception {
    Method method = Foo.class.getMethod("convertIterableToMap", Iterable.class);

    Type instanceType = new TypeToken<Foo<Integer>>() {}.getType();
    Type setOfString = new TypeToken<Set<String>>() {}.getType();

    // prints: java.util.Map<java.lang.Integer, java.lang.String>
    System.out.println(resolveReturnType(instanceType, method, setOfString));
  }
}