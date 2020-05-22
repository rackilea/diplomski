public interface DAO<T> {
    public void addItem(T item);
    public void updateItem(T item);
    public void removeItem(T item);
    public T getItem(int id);
    public List<T> getAll();
}