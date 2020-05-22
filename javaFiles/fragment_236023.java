public class GUI extends Application {
    private static Stage guiStage;

    public static Stage getStage() {
        return guiStage;
    }

    @Override
    public void start(Stage primaryStage) {
        guiStage = primaryStage;
        // other app initialization logic . . .
    }
}