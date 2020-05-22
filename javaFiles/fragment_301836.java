import java.lang.reflect.*;

public class Test {
    public static void main(String[] args) throws Exception {
        Object array = Array.newInstance(String.class, 10);

        // This would fail if it weren't really a string array
        String[] afterCasting = (String[]) array;
        System.out.println(afterCasting.length);
    }
}