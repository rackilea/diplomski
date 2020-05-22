public abstract class BaseVector<T extends Vector> implements Vector<T> {


    private final int x;
    private final int y;
    private final int z;


    public BaseVector(int x, int y, int z) {

        this.x = x;
        this.y = y;
        this.z = z;
    }


    protected abstract T createNew(int x, int y, int z);


    @Override
    public T sum(T other) {

        return createNew(x + other.getX(), y + other.getY(), other.getZ());
    }


    @Override
    public int getX() {

        return x;
    }


    @Override
    public int getY() {

        return y;
    }


    @Override
    public int getZ() {

        return z;
    }


    @Override
    public String toString() {

        return "BaseVector [x=" + x + ", y=" + y + ", z=" + z + "]";
    }

}