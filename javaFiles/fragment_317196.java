import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FontResizeIssueOnFocus extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Stage stage = primaryStage;
        HBox myHBox = new HBox();

        Label smallerText = new Label("this is small\ntext");
        smallerText.getStyleClass().add("smaller-text");

        Label biggerText = new Label("this is big\ntext");
        biggerText.getStyleClass().add("bigger-text");

        TextField myTextField = new TextField();
        myHBox.getChildren().addAll(smallerText, biggerText);

        VBox myVBox = new VBox();
        myVBox.getChildren().addAll(myHBox, myTextField);

        ScrollPane myScrollPane = new ScrollPane(myVBox);
        myScrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
        myScrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);

        Scene scene = new Scene(myScrollPane);
        scene.getStylesheets().add(getClass().getResource("scrollpanefontissue.css").toString());
        stage.setScene(scene);
        stage.show();
    }
}