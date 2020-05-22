// sound.Main
// This class does not actually create a JavaFX UI. Instead, it is
// only creating a JavaFX application to use Media
package sound;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author aga53
 */
public class Main extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        SoundPlayer s = new SoundPlayer("test.mp3");
        System.out.println("Hello World");
        s.play();
    }

}