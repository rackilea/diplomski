public class Main {
public static void main(String[] args) {
    LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
    cfg.title = "Game Name";
    cfg.fullscreen = false;
    cfg.vSyncEnabled = false;
    cfg.foregroundFPS = 120; // Change the FPS
    cfg.width = 1280;
    cfg.height = 720;

    new LwjglApplication(new MyGdxGame(), cfg);
}