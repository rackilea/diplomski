public class Multiplicator implements Operation {
    @Override
    public int op(int a, int b) {
        return a * b;
    }
}

// Usage
Operation operation = new Multiplicator();
System.out.println(operation.op(5, 2)); // 10