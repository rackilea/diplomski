import com.annimon.stream.Stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ItemChangedList<T> {
    private List<T> _listImplementation = new ArrayList<>();
    private List<OnPropertyChangedObserver<T>> _changedObserverList = new ArrayList<>();

    public static final String ITEM_ADDED = "bbed36af-0b7b-4e53-abc9-02d6a14d7f34";
    public static final String ITEM_REMOVED = "7390116e-586d-4e62-9343-5b82b0a8c6c5";

    public void add(T item) {
        sendPropertyChanged(item, ITEM_ADDED);
        _listImplementation.add(item);
    }

    public Iterator<T> iterator() {
        return _listImplementation.iterator();
    }

    public void clear() {
        for (T item : _listImplementation) {
            sendPropertyChanged(item, ITEM_REMOVED);
        }
        _listImplementation.clear();
    }

    public boolean contains(T item) {
        return _listImplementation.contains(item);
    }

    public void copyTo(T[] array, int arrayIndex) {
        // Using https://github.com/aNNiMON/Lightweight-Stream-API
        _listImplementation.addAll(Stream.of(array).skip(arrayIndex).toList());

        // Traditional Java way
        // _listImplementation.addAll(Arrays.stream(array).skip(arrayIndex).collect(Collectors.toList()));
    }

    public boolean remove(T item) {
        sendPropertyChanged(item, ITEM_REMOVED);
        return _listImplementation.remove(item);
    }

    public int count() {
        return _listImplementation.size();
    }

    public boolean isReadOnly() {
        return false;
    }

    public int indexOf(T item) {
        return _listImplementation.indexOf(item);
    }

    public void insert(int index, T item) {
        sendPropertyChanged(item, ITEM_ADDED);
        _listImplementation.add(index, item);
    }

    public void removeAt(int index) {
        _listImplementation.remove(index);
    }

    public T get(int index) {
        return _listImplementation.get(index);
    }

    public void set(int index, T item) {
        _listImplementation.set(index, item);
    }

    public void addObserver(OnPropertyChangedObserver<T> observer) {
        _changedObserverList.add(observer);
    }

    public void removeObserver(OnPropertyChangedObserver<T> observer) {
        _changedObserverList.remove(observer);
    }

    public void clearObserver() {
        _changedObserverList.clear();
    }

    private void sendPropertyChanged(T item, String args) {
        for (OnPropertyChangedObserver<T> observer : _changedObserverList) {
            observer.onChanged(item, args);
        }
    }

    public interface OnPropertyChangedObserver<T> {
        void onChanged(T item, String args);
    }
}