import java.util.*;
import java.util.stream.Stream;

public class Test {
    public static void main(String... args) {
        Stream.of("adam", "", null).filter(String::isEmpty).count();
    }
}