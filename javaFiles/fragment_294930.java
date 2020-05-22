public class ParentObject<T extends ChildObject> implements Iterable<T> {
    protected List<T> theChildObjects;

    public T getChildObjectByIndex(int idx) {
        return theChildObjects.get(idx);
    }

    public Iterator<T> iterator() {
        return java.util.Collections.unmodifiableCollection(this.theChildObjects).iterator();
    }
}