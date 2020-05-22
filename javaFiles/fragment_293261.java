import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

import javafx.collections.ModifiableObservableListBase;


public class ObservableLinkedList<T> extends ModifiableObservableListBase<T> implements Deque<T> {

    private final LinkedList<T> list = new LinkedList<>();

    @Override
    public void addFirst(T e) {
        list.addFirst(e);
        beginChange();
        nextAdd(0, 1);
        ++modCount ;
        endChange();
    }

    @Override
    public void addLast(T e) {
        list.addLast(e);
        int size = list.size();
        beginChange();
        nextAdd(size-1, size);
        ++modCount ;
        endChange();
    }

    @Override
    public boolean offerFirst(T e) {
        addFirst(e);
        return true ;
    }

    @Override
    public boolean offerLast(T e) {
        addLast(e);
        return true ;
    }

    @Override
    public T removeFirst() {
        T old = list.removeFirst() ;
        beginChange();
        nextRemove(0, old);
        ++modCount ;
        endChange();
        return old ;
    }

    @Override
    public T removeLast() {
        T old = list.removeLast() ;
        beginChange();
        nextRemove(list.size(), old);
        ++modCount ;
        endChange();
        return old ;
    }

    @Override
    public T pollFirst() {
        T result = list.pollFirst();
        if (result != null) {
            beginChange();
            nextRemove(0, result);
            ++modCount ;
            endChange();
        }
        return result ;
    }

    @Override
    public T pollLast() {
        T result = list.pollLast();
        if (result != null) {
            beginChange();
            nextRemove(list.size(), result);
            ++modCount ;
            endChange();
        }
        return result ;
    }

    @Override
    public T getFirst() {
        return list.getFirst() ;
    }

    @Override
    public T getLast() {
        return list.getLast() ;
    }

    @Override
    public T peekFirst() {
        return list.peekFirst() ;
    }

    @Override
    public T peekLast() {
        return list.peekLast() ;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {

        // not efficient: maybe a more efficient way, but we need the index...
        int index = list.indexOf(o);
        if (index > -1) {
            remove(index);
            return true ;
        } else {
            return false ;
        }
    }

    @Override
    public boolean removeLastOccurrence(Object o) {

        // not efficient: maybe a more efficient way, but we need the index...
        int index = list.lastIndexOf(o);
        if (index > -1) {
            remove(index);
            return true ;
        } else {
            return false ;
        }
    }

    @Override
    public boolean offer(T e) {
        return offerLast(e);
    }

    @Override
    public T remove() {
        return removeFirst();
    }

    @Override
    public T poll() {
        return pollFirst();
    }

    @Override
    public T element() {
        return getFirst();
    }

    @Override
    public T peek() {
        return peekFirst();
    }

    @Override
    public void push(T e) {
        addFirst(e);
    }

    @Override
    public T pop() {
        return removeFirst();
    }

    @Override
    public Iterator<T> descendingIterator() {
        return list.descendingIterator();
    }

    @Override
    public T get(int index) {
        return list.get(index);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    protected void doAdd(int index, T element) {
        list.add(index, element);
    }

    @Override
    protected T doSet(int index, T element) {
        return list.set(index, element);
    }

    @Override
    protected T doRemove(int index) {
        return list.remove(index);
    }

}