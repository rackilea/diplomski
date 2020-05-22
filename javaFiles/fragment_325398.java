public class ArrayBag<T> {
    private List<T> data;
    private int manyItems;
    public IntArrayBag() {
        final int INITIAL_CAPACITY = 10;
        manyItems = 0;
        data = new ArrayList<T>();
   }
}