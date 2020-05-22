public class MyFirstTriangleDesktop {
    public static void main (String[] argv) {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "my-gdx-game";
        cfg.useGL20 = false;
        cfg.width = 480;
        cfg.height = 320;

        new LwjglApplication(new MyGdxGame(), cfg);           
    }
}