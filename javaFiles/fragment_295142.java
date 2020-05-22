import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class A {
  public String aToString() {
    return "A";
  }
}

class B {
  public String bToString() {
    return "B";
  }
}

interface Function<IN, OUT> {
  OUT apply(IN input);//see guava for a prefab version of this
}

class ServiceClass {
  public static <T> void genericToString(Collection<T> c, Function<T, String> converter) {
    for (final T element : c) {
      System.out.println(converter.apply(element));
    }
  }

  public static void main() {
    List<A> listA = new ArrayList<>();
    listA.add(new A());
    ServiceClass.genericToString(listA, new Function<A, String>() {//the java 7 way
      @Override
      public String apply(final A input) {
        return input.aToString();
      }
    });

    List<B> listB = new ArrayList<>();
    listB.add(new B());
    ServiceClass.genericToString(listB, B::bToString);//the java 8 way
  }
}