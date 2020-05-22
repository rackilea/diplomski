package casino;

import java.util.Stack;

public class AbstractDeck<T extends Comparable<T>> implements Container<T> {
    protected Stack<T> items;

    @Override
    public T peek() {
        return items.peek();
    }

    @Override
    public T draw() {
        return items.pop();
    }

    @Override
    public boolean insert(T item) {
        return items.add(item);
    }

    @Override
    public void insertAt(int index, T item) {
        items.add(index, item);
    }

    @Override
    public void shuffle() {
        Actions.shuffle(items);
    }

    @Override
    public void sort() {
        Actions.sort(items);
    }
}