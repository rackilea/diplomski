public class B extends A {
    private int b;

    public B() {
        super(0);
    }

    @Override
    public int getA() {
        return b++;
    }
}