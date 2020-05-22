import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Base {

    private static final Set<String> allowedMethodNames = new HashSet<>(Arrays.asList("doThis", "wait", "wait", "wait", "equals", "toString", "hashCode", "getClass", "notify", "notifyAll"));

    public Base() {
        Set<String> allMethods = new HashSet<>();
        for (Method aMethod : getClass().getMethods()) {
            allMethods.add(aMethod.getName());
        }
        if (!allowedMethodNames.equals(allMethods)) {
            allMethods.removeAll(allowedMethodNames);
            throw new IllegalStateException("Following methods not allowed <" + allMethods + ">");
        }
    }

    public abstract void doThis();
}

public class Disallowed extends Base {

    @Override
    public void doThis() {
        System.out.println("dooooooo");
    }

    public void doSomethingElse() {
        System.out.println("not allowed");
    }

    public static void main(String[] args) {
            new Allowed().doThis();
        new Disallowed();
    }

}

public class Allowed extends Base {

    @Override
    public void doThis() {
        System.out.println("doing this");
    }


}