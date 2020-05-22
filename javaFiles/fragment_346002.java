public class Main extends Application {
@Override
public void start(Stage primaryStage) {
    try {

        //You have to Load the font before using it into css!!
        Font.loadFont(getClass().getResourceAsStream("/resources/fonts/8bit.ttf"), 14);
        Scene scene = new Scene(new GUIController());
        scene.getStylesheets().add(getClass().getResource("/view/application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Game of Life Settings");
        primaryStage.show();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static void main(String[] args) {
    launch(args);
 }
}