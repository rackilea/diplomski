public class ChangeVariable {
    static volatile int myVariable;
    static final Object lock = new Object();

    public static void setVariable(int value) {
        synchronized (lock) {
            myVariable = value;
        }
    }

    public static int getVariable() {
        synchronized (lock) {
            return myVariable;
        }
    }
}