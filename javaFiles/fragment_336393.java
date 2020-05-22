import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RectangleAutosize extends Application {

    static class ResizableRectangle extends Rectangle {
        ResizableRectangle(double w, double h) {
            super(w, h);
        }

        @Override
        public boolean isResizable() {
            return true;
        }

        @Override
        public double minWidth(double height) {
            return 0.0;
        }
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        HBox hBox = new HBox();

        hBox.setAlignment(Pos.CENTER);

        Rectangle rect = new ResizableRectangle(hBox.getWidth(),50);
        rect.setFill(Color.RED);
        rect.widthProperty().bind(hBox.widthProperty().subtract(20));

        hBox.getChildren().add(rect);

        borderPane.setCenter(hBox);

        Scene scene = new Scene(borderPane, 900, 600, Color.WHITE);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}