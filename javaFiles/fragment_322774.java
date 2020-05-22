import java.util.*;

class Test {
    public static final Map<String,Object> map;

    static {
        Map<String,Object> contents = new HashMap<>();

        map = Collections.unmodifiableMap(contents);
    }
}