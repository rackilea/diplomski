import java.util.function.IntUnaryOperator;

public class Accumulator {
    public static IntUnaryOperator foo(int n) {
        return new IntUnaryOperator() {
            private int value = n;
            @Override
            public int applyAsInt(int i) {
                return value += i;
            }
        };
    }

    public static void main(String... args) {
        IntUnaryOperator accumulator = foo(1);
        System.out.println(accumulator.applyAsInt(2)); // output: 3
        System.out.println(accumulator.applyAsInt(3)); // output: 6
    }
}