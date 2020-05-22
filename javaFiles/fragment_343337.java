class MyObj {

  private final List<Type> list;

  MyObj(/* Some arguments that control initial list contents */) {
    List<Type> tmp = new ArrayList<>();
    tmp.add(...);
    list = Collections.synchronizedList(tmp);
  } /* Reference to `tmp` is lost, safety is ensured. */

}