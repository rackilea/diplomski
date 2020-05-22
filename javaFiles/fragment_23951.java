import java.util.function.Function;

public class Main {
    private static abstract class ParentClass implements Function<String, String> {
        protected String prefix = "parent_class_";
    }

    public static void main(String... args) {
        String prefix = "local_";
        printString("test", new ParentClass() {
            @Override
            public String apply(String s) {
                return prefix + s;
            }
        });
        printString("test", s -> prefix + s);
    }

    private static void printString(String baseString, Function<String, String> stringMapper) {
        System.out.println(stringMapper.apply(baseString));
    }
}