public class DesktopLauncher  implements PlatformResolver{

    public void handleTasks(){
        Gdx.app.log("Desktop", "Would handle tasks now.");
    } 

    public static void main (String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "My GDX Game";
        config.width = 480;
        config.height = 800;
        new LwjglApplication(new MyGame(this), config);
    }
}