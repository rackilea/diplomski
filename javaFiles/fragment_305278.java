import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Characters extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Create the pane
        // GridPane pane = new GridPane();
        Pane pane = new Pane();
        pane.setPrefSize(600, 600);

        // pane.setAlignment(Pos.CENTER);

        // Font class instance
        Font font = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 35);

        // Welcome to Java string
        String welcome = "Welcome to Java";
        double rotation = 90;
        double offset = pane.getPrefWidth() / 2;
        double radius = 100;
        double x = offset + Math.cos(rotation) * radius;
        double y = offset + Math.sin(rotation) * radius;

        // Loop
        for (int i = 0; i < welcome.length(); i++) {
            x = offset + Math.cos(Math.toRadians(rotation)) * radius;
            y = offset + Math.sin(Math.toRadians(rotation)) * radius;
            System.out.println("Y: " + y);
            System.out.println("X: " + x);
            Text text = new Text(x, y, welcome.charAt(i) + "");
            System.out.println("Actual X" + text.getX());
            System.out.println("Actual Y" + text.getY());

            text.setFont(font);
            text.setRotate(rotation);
            pane.getChildren().add(text);
            rotation += 22.5;
        }

        // Create the scene for the application
        // Scene scene = new Scene(pane, 500, 500);
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Characters around circle");
        primaryStage.setScene(scene);
        // Display
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}