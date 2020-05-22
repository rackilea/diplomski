public interface Vector<T extends Vector> {

    public int getX();
    public int getY();
    public int getZ();

    public T sum(T other);
}