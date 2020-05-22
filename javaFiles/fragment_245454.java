public class MainNoWaitAction {

    public static void main(String[] args) {
        List<String> links;
        Object otherVariable;

        String title = "title";

        links = noWait(() -> rowFindElements(title));
        otherVariable = noWait(() -> createAnObject());
    }

    public static <T> T noWait(Supplier<T> supplier) {
        turnOffWait();
        try {
            return supplier.get();
        } finally {
            turnOnWait();
        }
    }

    private static void turnOnWait() { /* skipped */ }
    private static void turnOffWait() { /* skipped */ }

    private static List<String> rowFindElements(String title) {
        return new ArrayList<>(); // populate the list
    }

    private static Object createAnObject() {
        return new Object();
    } 
}