public class MainWithAction {

    public static void main(String[] args) {
        noWait(() -> doSomething());
    }

    public static void noWait(Action action) {
        turnOffWait();
        action.apply();
        turnOnWait();
    }

    public static void doSomething() { /* do something */ }
    public static void turnOnWait() { /* skipped */ }
    public static void turnOffWait() { /* skipped */ }
}