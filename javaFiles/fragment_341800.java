public class HeadlessLauncher {
    public static void main(final String[] args) {
        final HeadlessApplicationConfiguration config = new HeadlessApplicationConfiguration();
        config.renderInterval = Globals.TICK_RATE; // Likely want 1f/60 for 60 fps
        new HeadlessApplication(new MyApplication(), config);
    }
}