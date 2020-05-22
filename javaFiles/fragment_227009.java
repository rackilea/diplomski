abstract class AType<T> {
    private T value;

    // standard getter/setter
    public T getValue() { return this.value; }
    public void setValue(T value) { this.value = value; }
}

class SpecTypeInt extends AType<Integer> {
}

class SpecTypeString extends AType<String> {
}

interface Instantiable<T> {
    T instantiate();
}