import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        final Consumer<Integer> simpleReference = Main::someMethod;
        simpleReference.accept(1);
        simpleReference.accept(2);
        simpleReference.accept(3);

        final ComplexInterface complexReference = Main::complexMethod;
        final String complexResult = complexReference.someMethod("888", 321, new ArrayList<>());
        System.out.println(complexResult);
    }

    private static void someMethod(int value) {
        System.out.println(value);
    }

    private static String complexMethod(String stringValue, int intValue, List<Long> longList) {
        final StringBuilder builder = new StringBuilder();
        builder.append(stringValue).append(" : ").append(intValue);
        for (Long longValue : longList) {
            builder.append(longValue);
        }
        return builder.toString();
    }

    @FunctionalInterface
    public static interface ComplexInterface{
        String someMethod(String stringValue, int intValue, List<Long> longList);
    }
}