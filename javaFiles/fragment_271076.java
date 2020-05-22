public interface Func<E, T> {
    T apply(E e);
}

public class CollectionUtils {

    public static <T, E> List<T> transform(List<E> list, Func<E, T> f) {
        if (null == list)
            throw new IllegalArgumentException("null list");
        if (null == f)
            throw new IllegalArgumentException("null f");

        List<T> transformed = new ArrayList<T>();
        for (E e : list) {
            transformed.add(f.apply(e));
        }
        return transformed;
    }
}

List<CustomerDto> transformed = CollectionUtils.transform(l, new Func<Customer, CustomerDto>() {
    @Override
    public CustomerDto apply(Customer e) {
        // return whatever !!!
    }
});