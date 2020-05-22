interface Visitor {
    public A accept(A a);
    public B accept(B b);
}

class A {
    public A sum(A a) {
        System.out.println("A.sum(A) called");
        return null;
    }

    public A visit(Visitor sv) {
        return sv.accept(this);
    }
}

class B extends A {
    public B sum(B b) {
        System.out.println("B.sum(B) called");
        return null;
    }

    public B visit(Visitor sv) {
        return sv.accept(this);
    }
}

public class Test {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        A basa = new B();

        a.visit(new SumVisitor(b));        // a.sum(b);
        b.visit(new SumVisitor(b));        // b.sum(b);
        basa.visit(new SumVisitor(b));     // basa.sum(b);
        basa.visit(new SumVisitor(basa));  // basa.sum(basa);
    }

    static class SumVisitor implements Visitor {
        A arg;
        SumVisitor(A arg) { this.arg = arg; }
        public A accept(A a) { return a.sum(arg); }
        public B accept(B b) { return b.sum(arg); }
    }
}