public class A {
    public String[] data;

    public B doFooB() {
        return new B(this);
    }

    public String[] getWhatINeed() {
        return data;
    }
}

class B {
    public A a;

    public B(A a) {
        this.a = a;
    }

    public getWhatINeed() {
        return a.getWhatINeed();
    }

    public C doFooC() {
        return new C(this);
    }
}

class C {
    public B b;

    public C(B b) {
        this.b = b;
    }

    public String[] doFooC() {
        return b.getWhatINeed();
    }
}