import javafx.application.Application;
import javafx.stage.Stage;

public class Main {
    public static class Window extends Application {
        @Override
        public void start(Stage stage) {
            stage.show();
        }
    }

    public static void main(String args[]) {
        Application.launch(Window.class, args);
    }
}