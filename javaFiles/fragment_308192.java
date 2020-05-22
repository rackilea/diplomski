public class MyRandom extends Random {
    public MyRandom() {}
    public MyRandom(int seed) { super(seed); }

    public int nextNonNegative() {
        return next(Integer.SIZE - 1);
    }
}