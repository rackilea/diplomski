public class Test<E> {
    private List<E> list;

    public Test(List<E> useThisList) {
        this.list = useThisList;
    }

    public void add(E add) {
        this.list.add(add); // this will compile
    }
}