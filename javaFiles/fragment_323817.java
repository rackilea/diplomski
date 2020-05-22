public class DesktopLauncher {
    public static void main (String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.height =1024;
        config.width= 768;
        config.resizable = false;
        config.title= "My App Title";
        System.setProperty("org.lwjgl.opengl.Window.undecorated", "true"); 
        new LwjglApplication(new Game(), config);
    }
}