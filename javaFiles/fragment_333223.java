-- WrapperFactory.java
public class WrapperFactory<T> {

   public T wrap(T item);

}

-- WrappingList.java
/**
 * A self-wrapping list.
 *
 * @param T the stored, wrapped item type
 */
public class WrappingList<T> implements List<T> {
    private List<T> wrappedList;
    private WrapperFactory<T> wrapper;

    public WrappingList(List<T> wrappedList, WrapperFactory<T> wrapper) {
        this.wrappedList = wrappedList;
        this.wrapper = wrapper;
    }

    ....

    public boolean add(T item) {
        return wrappedList.add(wrapper.wrap(item));
    }

}