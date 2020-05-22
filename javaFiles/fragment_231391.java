import java.util.*;

public class Test {
    public static void main(String[] args) {
        Properties defaults = new Properties();
        defaults.setProperty("x", "x-default");

        Properties withDefaults = new Properties(defaults);
        withDefaults.setProperty("x", "x-new");
        withDefaults.remove("x");
        // Prints x-default
        System.out.println(withDefaults.getProperty("x"));

        Properties withCopy = new Properties();
        withCopy.putAll(defaults);
        withCopy.setProperty("x", "x-new");
        withCopy.remove("x");
        // Prints null
        System.out.println(withCopy.getProperty("x"));
    }
}