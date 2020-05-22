class SomeClass {
    Object value; // erasure of T is Object

    Object get() {
        return value;
    }

    void set(Object val) {
        value = val;
    }
}