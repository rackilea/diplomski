class B<T extends String> {
    protected T value;

    public T getValue() {
        return value;
    }

    public void handleValue() {
        System.out.println(this.getValue().substring(0, 5));
    }
}

public class A {
    public static void main(String[] args) {
        B obj = new B<String>();
        obj.handleValue();
    }
}