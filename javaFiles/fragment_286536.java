public class ListType<E> extends ArrayList<E> {
    public void removeRange(int fromIndex, int toIndex) {
        // your remove logic here
        ...

        // now you can use E here
        E temp = remove(i);
        return;
    }
}