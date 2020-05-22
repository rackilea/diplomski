public abstract class Test<I,O extends Number> {

    List<I> list = new ArrayList<>();

    public O performOperation(Function<I,O> function) {
        return list.stream().map(function).reduce((a,b)->operation(a,b)).get();
    }

    public void add(I i) {
        list.add(i);
    }

    public abstract O operation(O a,O b);
}