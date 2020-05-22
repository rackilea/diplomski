class A {
    public int a = 10;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;       
    }    
}

class B extends A {
    public int a = 20;
}
class C extends B {
    public int getA() {
        return a;
    }
}

public class Demo {
    public static void main(String args[]) {
        B a = new B();
        System.out.println(a.getA());        

        C c = new C();
        System.out.println(c.getA());        
    }
}