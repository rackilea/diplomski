abstract class B<T extends String> {
    protected T value;

    public T getValue() {
        return value;   
    }

    public void handleValue() {
        System.out.println(this.getValue().substring(0, 5));
    }
}

class C extends B<String>{
    public C() {
        this.value = "Hello World";
    }
}

public class A {
    public static void main(String[] args) {
        C obj = new C();
        obj.handleValue(); // prints Hello
    }
}