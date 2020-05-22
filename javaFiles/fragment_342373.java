import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import MyButton.SplitMode;

public class SimpleTest
    extends Application {

    Stage primaryStage;
    protected ContextMenu popup;

    @Override
    public void start(final Stage stage) throws Exception {
        primaryStage = stage;
        primaryStage.setTitle("SimpleTest.");

        Label label = new Label();
        Button rotate = new Button("Rotate");
        MyButton b = new MyButton("My Test", SplitMode.SPLIT_TOP);
        label.setText(b.getSplitMode().toString());
        StackPane sp = new StackPane();
        sp.setPrefSize(200, 200);
        sp.getStylesheets().add("test.css");

        rotate.setOnAction((ActionEvent t) -> {
            switch(b.getSplitMode()){
                case SPLIT_TOP:
                    b.setSplitMode(SplitMode.SPLIT_RIGHT);
                    break;
                case SPLIT_RIGHT:
                    b.setSplitMode(SplitMode.SPLIT_BOTTOM);
                    break;
                case SPLIT_BOTTOM:
                    b.setSplitMode(SplitMode.SPLIT_LEFT);
                    break;
                case SPLIT_LEFT:
                    b.setSplitMode(SplitMode.HIDDEN);
                    break;
                case HIDDEN:
                    b.setSplitMode(SplitMode.SPLIT_TOP);
                    break;
            }
            label.setText(b.getSplitMode().toString());
        });
        StackPane.setAlignment(label, Pos.TOP_LEFT);
        StackPane.setAlignment(rotate, Pos.TOP_RIGHT);
        sp.getChildren().addAll(b, label, rotate);
        primaryStage.setScene(new Scene(sp));
        primaryStage.toFront();
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
   }