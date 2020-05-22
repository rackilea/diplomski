// This is not going to work! The syntax is not real.
public class GenericComposite<T> implements T {
    List<T> m_items;

    void add(T item) {
        m_items.add(item);
    }

    @Override
    <all-methods-of-T>();
}