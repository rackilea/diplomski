public class EffectiveLevel {

    private static final Logger PARENT = Logger.getLogger("com.logtests");
    private static final Logger CHILD = Logger.getLogger("com.logtests.TestClass");

    public static void main(String[] args) {
        PARENT.setLevel(Level.OFF);
        CHILD.setLevel(Level.ALL);
        System.out.println(PARENT.getName() + " " + PARENT.getLevel());
        System.out.println(CHILD.getName() + " " + CHILD.getLevel());
    }
}