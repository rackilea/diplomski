public class JavaObjWithArray<T> {

    private T[] items;

    public JavaObjWithArray(T[] items) {
        this.items = (T[]) new Object[items.length];
        System.arraycopy(items, 0, this.items, 0, items.length);
    }

    public T[] getItems() {
        return items;
    }

}

fun main(args: Array<String>) {
    val obj = JavaObjWithArray(arrayOf("a", "b"))

    val one = obj.items.get(0)
    val two = obj.items[0]
}