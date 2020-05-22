abstract class Base<T extends Base<T>> {
    protected final Base<T> getOp1() {
         return condition() ? getNewInstance() : this;
    }
    protected abstract Base<T> getNewInstance(); 
    public abstract Base<T> combine(T other);
}



class Variant<T extends Variant<T>> extends Base<T> {
    protected Base<T> getNewInstance() { 
        return new Variant(); 
    }

    public Base<T> combine(T op2) {
        Variant<T> op1 = (Variant<T>) getOp1();   // <- explicit cast
        op1.calculate(op2);
        return op1;
    }

    private void calculate(Base<T> other) { 
        // ...
    }
}