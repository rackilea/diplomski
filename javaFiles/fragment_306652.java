import java.lang.reflect.*;
import java.util.*;

public class Test {

    public static void main(String[] args) throws Exception {
        Map<Character, Method> methodMap = new HashMap<Character, Method>();

        methodMap.put('h', Test.class.getMethod("showHelp"));
        methodMap.put('t', Test.class.getMethod("teleport"));

        char cmd = 'h';
        methodMap.get(cmd).invoke(null);  // prints "Help"

        cmd = 't';
        methodMap.get(cmd).invoke(null);  // prints "teleport"

    }

    public static void showHelp() {
        System.out.println("Help");
    }

    public static void teleport() {
        System.out.println("teleport");
    }
}