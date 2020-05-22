interface C {}

class B {}

class D extends B implements C {}

public class A {
    public static void main(String args[]) {
        B obj = new D();
        System.out.println(obj instanceof C);      //compiles and gives true as output  
    }
}