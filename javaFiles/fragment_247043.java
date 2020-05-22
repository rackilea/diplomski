public class Glue<T extends Serializable & Comparable<T>> {

  private List<Type<T>> types;

  private Glue() { types = new ArrayList<Type<T>>(); }
  private static class Type<T> {
      private T value;
      /* some other properties, omitted for simplicity */
      public Type(T value) { this.value = value; }
  }

  public static <V extends Serializable & Comparable<V>> Glue<V> glueFactory(
      String name, V first, V second) {
      Glue<V> g = new Glue<V>();
      Type<V> firstType = new Glue.Type<V>(first);
      Type<V> secondType = new Glue.Type<V>(second);

      g.types.add(firstType);
      g.types.add(secondType);
      /* omitted complex stuff */
      return g;
  }
}

public class Horse implements Serializable, Comparable<Horse> {
  private static final long serialVersionUID = 1156763996034008367L;

  @Override
  public int compareTo(Horse o) {
     return 0;
  }      
}

public class Cat  { }

public static void main(String[] args) {
  Glue<Horse> gh = Glue.glueFactory("2HP", new Horse(), new Horse());
  Glue<Cat> gc = Glue.glueFactory("2C", new Cat(), new Cat()); // <--- Does not compile, as requested!!
}