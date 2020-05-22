public class Test {

  public static void main(String args[]) throws NoSuchMethodException {
    Method method = Foo.class.getDeclaredMethod("getBars", new Class[]{});
    Type grt = method.getGenericReturnType();
    if (grt instanceof ParameterizedType) {
      Type Bar = ((ParameterizedType) grt).getActualTypeArguments()[0];
      System.out.println(Bar);
    }
  }
}

class Foo {
  List<Bar> getBars() {
    return Collections.emptyList();
  }
}

class Bar {
}