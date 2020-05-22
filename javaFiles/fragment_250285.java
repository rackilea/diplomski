interface StudentList<T> {
    public Iterator<T> getIterator();
    public T get(int index);
    public void add(T element);
    public void remove(T element);
}