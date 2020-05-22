public static <E, F> List<F> copyIf(List<E> source,
    List<F> destination, Class<F> cls) {
  for (E e : source) {
    if (cls.isAssignableFrom(e.getClass())) {
      destination.add((F) e);
    }
  }
  return destination;
}

public static void main(String[] args) {
  String s = "Hello";
  List<String> al = new ArrayList<String>();
  al.add(s);
  System.out.println(copyIf(al, new ArrayList<String>(), String.class));
}