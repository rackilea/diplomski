interface MyList<T> {
    public void addFront(T thing);

    public void remove(int pos);

    public void removeEnd();

    public T get(int pos);

    public int length();

    public boolean isEmpty();

}