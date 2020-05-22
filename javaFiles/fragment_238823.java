public class SomeClass<T> {
    private List<? extends T> list;

    public void setList(List<? extends T> list) {
        this.list = list;
    }
}

public class SomeConcreteClass extends SomeClass<Integer> {

    public void doSomething() {
        List<Integer> list = new ArrayList<Integer>();
        setList(list);
    }
}