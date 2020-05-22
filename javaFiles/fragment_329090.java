public class List<T>{
    T val;
    List<T> next;

    public List(T val, List<T> next) {
        this.val = val;
        this.next = next;
    };

    public T getVal() {
        return val;
    }
}