public abstract class SuperClass<T extends SuperClass<T>> {
    protected T that;
    public T chain() {
        return that;
    }
}

public class SubClass1 extends SuperClass<SubClass1> {
    public SubClass1() {
        that = this;
    }
}

public class SubClass2 extends SuperClass<SubClass2> {
    public SubClass2() {
        that = this;
    }
}