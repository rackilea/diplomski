@FunctionalInterface
public interface StringCombiner {
    String combine(String s1, String s2);
    default String bar(String s1, String s2) { return "bar"; }
}

//Note: you need the static block to avoid a "self-reference" compilation error
static StringCombiner sc;
static {
  sc = (s1, s2) -> sc.bar(s1, s2) + s1 + s2;
}

public static void main(String[] args) {
    System.out.println(sc.combine("a", "b"));
}