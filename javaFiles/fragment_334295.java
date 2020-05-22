public class A {
    final int x, y, z;

    public A() {
        this(0);
    }
    public A(int x) {
        this (x, 0);
    }
    public A(int x, int y) {
        this(x, y, 0);
    }

    public A(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        // optionally, some setup stuff needed for all A
    }
}