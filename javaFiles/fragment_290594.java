public class Base {
    public void foo() {System.out.println("base");}
}
public class A extends Base {
    public void foo() {System.out.println("a");}
}
public class B extends Base {
    public void foo() {System.out.println("b");}
}
public class AB extends A, B /* imagine that it's a possibility */{
}