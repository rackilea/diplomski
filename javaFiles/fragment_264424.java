public void test() {
  List<? extends Object> a1 = new ArrayList<> ();
  List<? extends Object> a2 = new ArrayList<> ();
  m(a1, a2); //your compilation error here
}
public <T> void m(List<T> a1, List<T> a2) { }