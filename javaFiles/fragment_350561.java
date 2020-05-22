import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class StageDecorationThicknessTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        Spinner<Integer> spinner = new Spinner<>(1, 10, 1);
        Button open = new Button("Open Windows");
        open.setOnAction(e -> {
            int numWindows = spinner.getValue() ;
            Parent root = primaryStage.getScene().getRoot();
            Bounds localRootBounds = root.getBoundsInLocal();
            Point2D localRootTopLeft = new Point2D(localRootBounds.getMinX(), localRootBounds.getMinY());
            Point2D screenRootTopLeft = root.localToScreen(localRootTopLeft);
            double stageTopBorderThickness = screenRootTopLeft.getY() - primaryStage.getY() ;

            Stage owner = primaryStage ;
            for (int i = 0 ; i < numWindows ; i++) {
                Stage stage = new Stage();
                Button close = new Button("Close");
                close.setOnAction(evt -> stage.hide());
                Scene scene = new Scene(new StackPane(close), primaryStage.getScene().getWidth(), 80);
                stage.initOwner(owner);
                stage.initModality(Modality.WINDOW_MODAL);
                stage.setScene(scene);
                stage.setX(primaryStage.getX());
                stage.setY(screenRootTopLeft.getY() + i * stageTopBorderThickness);
                stage.show();
                owner = stage ;
            }
        });

        VBox root = new VBox(10, spinner, open);
        root.setPadding(new Insets(5));
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}