class A {
    int x;
    int y;

public:
    // note: we don't initialize members in the body
    A(int x, int y): x(x), y(y) {}
};

class B {
    A a;
    int z;

public:
    B(A a, int z): a(a), z(z) {}
};