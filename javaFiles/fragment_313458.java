public class Generic5 {
    MyNewType t;
    Comparable comparable;

    Generic5(MyNewType t) {
        this.t = t;
    }

    Generic5(Comparable comparable) {
        this.comparable = comparable;
    }
}

class MyNewType implements Comparable, Runnable { ... }