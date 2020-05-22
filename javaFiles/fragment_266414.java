public class YourList<T> {
    private ArrayList<T> list;

    public YourList() {
        list = new ArrayList<>();
    }
    // example method
    public void add(T t) {
        list.add(t);
    }

}