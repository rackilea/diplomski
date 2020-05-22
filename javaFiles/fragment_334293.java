public A(int x, int y, int z) {
    this(x, y);
    this.z = z;
}

public A(int x, int y) {
    this(x);
    this.y = y;
}

public A(int x) {
    this();
    this.x = x;
}

public A() {
    // some setup stuff needed for all A
}