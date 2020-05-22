package myPkg;
public class CLHUtilities {

    private static boolean saying = false;
    public static void tracing(boolean b) {
        saying = b;
    }

    /*
     * Technique taken from:
     * http://stackoverflow.com/questions/282977/which-class-invoked-my-static-method
     */
    public static void say(String s) {
        if (saying) {
            Throwable t = new Throwable();
            StackTraceElement[] trace = t.getStackTrace();
            String className = trace[1].getClassName();
            String whoCalledMe = null;
            try {
                whoCalledMe = Class.forName(className).getSimpleName();
            } catch (Exception e) {
            }
            System.out.println(whoCalledMe + ": " + s);
        }

    }
}