public interface ISomething {
    public void something();
}

public WrapperA implements ISomething {
    private A a;

    WrapperA(A a) {
       this.a = a;
    }

    public void something() {
        return a.something();
    }
}

public WrapperB implements ISomething {
    private B b;

    WrapperB(B b) {
       this.b = b;
    }

    public void something() {
        return b.something();
    }
}

A instanceOfA = ...;
ISomething some = new Wrapper(instanceOfA);
some.something();