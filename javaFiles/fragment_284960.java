abstract class A {
    public abstract void callExecute(MyClass back);
}
class B extends A {
    public void callExecute(MyClass back) {
        back.execute(this);
    }
}
class C extends A {
    public void callExecute(MyClass back) {
        back.execute(this);
    }
}

class MyClass {
    private final A model;

    public MyClass(A m) {
        this.model = m;
    }

    public void doSomething() {
        System.out.println(this.model instanceof C); //TRUE!!
        model.callExecute(this.model);
    }

    public void execute(B m) {
        System.out.println("noo");
    }

    public void execute(C m) {
        System.out.println("yay");
    }
}