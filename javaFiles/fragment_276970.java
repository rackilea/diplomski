class Base {
    private int value;

    Base(int v) {
        this.value = v;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int v) {
        this.value = v;
    }
}

class Derived extends Base {
    Derived(int v) {
        super(v);
    }
}