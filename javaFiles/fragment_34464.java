import java.util.*;

public class Test {
    private final int minLength;

    private Test(int minLength) {
        this.minLength = minLength;
    }

    public boolean checkAny(Collection<String> things) {
        return things.stream().anyMatch(this::check);
    }

    private boolean check(String x) {
        return x.length() >= minLength;
    }

    public static void main(String[] args) throws Exception {
        Test t = new Test(5);
        List<String> shortStrings = Arrays.asList("asd", "bcd", "foo");
        List<String> mixedStrings = Arrays.asList("asd", "bcd", "this is long", "foo");
        System.out.println(t.checkAny(shortStrings)); // false
        System.out.println(t.checkAny(mixedStrings)); // true
    }    
}