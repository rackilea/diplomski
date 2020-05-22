public class myList<T extends Number> implements Collection<T> {

    private DoubleFunction<T> fromDoubleFunction;

    public myList(DoubleFunction<T> function) {
        this.fromDoubleFunction = function;
    }

    public boolean add(double value) {
        return this.add(this.fromDoubleFunction.apply(value));
    }

    //rest of code
}