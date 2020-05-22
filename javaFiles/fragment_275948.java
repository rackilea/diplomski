import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MyJavaProgram extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button showMeSomethingButton = new Button("Show me something");
        showMeSomethingButton.setOnAction(e -> {
            MyJavaFXProgram myProgram = new MyJavaFXProgram();
            showInModalWindow(myProgram.getView());
        });
        Button exitButton = new Button("Exit");
        exitButton.setOnAction(e -> Platform.exit());

        VBox root = new VBox(10, exitButton, showMeSomethingButton);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showInModalWindow(Parent view) {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(view));
        stage.show();
    }


}