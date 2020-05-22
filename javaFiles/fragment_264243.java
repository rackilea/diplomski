public class RestletLauncher {
    public static void main(String[] args) {
        Engine.getInstance().setLogLevel(Level.FINEST);
        launchApplication();
    }
}