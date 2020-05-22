public interface BetterCollection<E> extends Collection<E> {
    BetterCollection<E> withoutNulls();
}

public class BetterLinkedList<E> extends LinkedList<E> implements BetterCollection<E> {
    public BetterLinkedList() {}

    public BetterLinkedList(LinkedList<E> input) {
        super(input);
    }

    @Override
    public BetterCollection<E> withoutNulls() {
        BetterCollection<E> result = new BetterLinkedList<E>();
        ...
        return result;
    }
}