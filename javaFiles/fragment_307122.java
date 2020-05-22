class A {
  public String method1() {
        if(this instanceof B) {
          return "Class B";
          //do something for class B
        } else if (this instanceof C) {
          return "Class C";
          //do something for class C
        }
        return "";
    }
}
class B extends A { }
class C extends A { }
public class Main {
    public static void main(String[] args) {
        A[] elements = {new A(),new B()};
        for (int i = 0; i < elements.length; i++)
            System.out.println(elements[i].method1());
    }
}