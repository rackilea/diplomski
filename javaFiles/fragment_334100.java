class Pair<T extends Comparable<T>> implements Comparable<Pair<T>> {
  final T a;
  final T b;

  public Pair ( T a, T b ) {
    this.a = a;
    this.b = b;
  }

  @Override
  public int compareTo(Pair<T> o) {
    // Comparison on 'a' only.
    return a.compareTo(o.a);
  }

  @Override
  public String toString () {
    return "{" + a + "," + b + "}";
  }
}

public static void main(String args[]) {
  Pair[] pairs = {
    new Pair(1,2),
    new Pair(7,4),
    new Pair(6,8),
  };
  System.out.println("Before: "+Arrays.toString(pairs));
  Arrays.sort(pairs);
  System.out.println("After: "+Arrays.toString(pairs));
}