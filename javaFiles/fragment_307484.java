public class FibonacciAlgorithm {

    private int a = 0;

    private int b = 1;

    public FibonacciAlgorithm() {

    }

    public int increment() {
        int temp = b;
        b = a + b;
        a = temp;
        return value;
    }

    public int getValue() {
        return b;
    }
}