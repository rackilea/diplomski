enum E1 { e1 };
enum E2 { e2 };

public  class Test <E extends Enum> {
  List<E> list = new ArrayList<>();

  void add(E e) { list.add(e); } 
  void dump() { System.out.println(list); }

  public static void main(String[] args) throws Exception {
    Test<Enum> test = new Test<>();
    test.add(E1.e1);
    test.add(E2.e2);
    test.dump();    
  }
}