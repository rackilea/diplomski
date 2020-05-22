public class Window {
    private static Window INSTANCE = null;

    public static Window getWindow() {
        if (INSTANCE == null) {
            INSTANCE = new Window();
        }
        return INSTANCE;
    }
}