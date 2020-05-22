public class Main2 {
public static void main(String[] args) {
    List<String> l1 = new ArrayList<>();
    l1.add(new String("hello"));
    List<String> l2 = new ArrayList<>();
    l2.add(new String("hello"));

    System.out.println(l1.equals(l2)); //true

    List<Test> t1 = new ArrayList<>();
    t1.add(new Test());
    List<Test> t2 = new ArrayList<>();
    t2.add(new Test());

    System.out.println(t1.equals(t2)); //false
    }
}

 class Test{
  }