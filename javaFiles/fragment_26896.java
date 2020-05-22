import static helpers.Artist.BeginSession;
import org.lwjgl.opengl.Display;
import helpers.Clock;
import helpers.StateManager;

public class Boot {

public Boot() {

    //Call static method in Artist class to initialize OpenGL calls
    BeginSession();
    Thread backgroundPlayer;
    Try {
        backgroundPlayer = new Thread(new MusicBackground());
        backgroundPlayer.start();
    }
    catch(Exception e)
    {
        System.out.println("Problem firing the background thread");
        e.printStackTrace();
    }

    //Main game loop
    while (!Display.isCloseRequested()) {
        Clock.update();
        StateManager.update();
        Display.update();
        Display.sync(60);
    }
    Display.destroy();
}

public static void main(String[] args) {
new Boot();
}
}