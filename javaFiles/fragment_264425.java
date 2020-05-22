public void test() {
  List<SomeBaseClass> a1 = new ArrayList<> ();
  List<SomeBaseClass> a2 = new ArrayList<> ();
  m(a1, a2); //compiles fine
}
public <T> void m(List<T> a1, List<T> a2) { }