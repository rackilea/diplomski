import java.util.*;

public class Main{

    public static void main(String[] args) {
        Collection<String> strings = Arrays.asList("x", "y");
        Set<String> set = new BrokenSet<>(strings);
    }

}