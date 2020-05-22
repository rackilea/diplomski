interface A {
    void a();
}

class B implements A {
    private int value;

    void a() { ... }

    B(int value) { this.value = value; }
}