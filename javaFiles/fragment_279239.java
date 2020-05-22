import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PopupExample extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.TOP_CENTER);
        Button showPopUpbutton = new Button("Show Stage_TWO");
        showPopUpbutton.setOnAction(event -> showPopup());
        vBox.getChildren().add(showPopUpbutton);
        Scene scene = new Scene(vBox, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Stage_One");
        primaryStage.show();
    }

    private void showPopup()
    {
        Stage stage = new Stage();
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.TOP_CENTER);
        Label label = new Label("Stage_TWO");
        Button closeStageButton = new Button("Close Stage_TWO");
        closeStageButton.setOnAction(event -> stage.close());
        vBox.getChildren().addAll(label, closeStageButton);
        Scene scene = new Scene(vBox, 200, 200);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Stage_TWO");
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}