public class A extends B{
    int z;// B has x and y

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
        super(x, y);
        this.z = z;
        // optionally, some setup stuff needed for all A
    }
}