import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Main extends Application {
@Override
public void start(final Stage stage) {
    try {
        ///// 2nd scene
        final BorderPane root2 = new BorderPane();
        root2.setPrefSize(stage.getWidth(),stage.getHeight());
        HBox buttons2=new HBox(50);
        buttons2.getChildren().addAll(new Button("Button1"),new Button("Button2"));
        buttons2.setAlignment(Pos.BOTTOM_CENTER);
        root2.setBottom(buttons2);
//        final Scene scene2 = new Scene(root2,stage.getWidth(),stage.getHeight());
        ///// 1st scene
        VBox buttons1=new VBox();
        buttons1.setPrefSize(stage.getWidth(),stage.getHeight());
        Button nextSceneBtn=new Button("NEXT");
        buttons1.getChildren().add(nextSceneBtn);
        buttons1.setAlignment(Pos.CENTER);
        final Scene scene1=new Scene(buttons1,stage.getWidth(),stage.getHeight());

            ////action event
            nextSceneBtn.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
//                    stage.setScene(scene2);
                    scene1.setRoot(root2);
                }

            });
            ///stage
            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();
            stage.setX(0);
            stage.setY(0);
            stage.setWidth(bounds.getWidth());
            stage.setHeight(bounds.getHeight());

            stage.setScene(scene1); //if it's #setScene(scene2) at the beginning, it's ok
        stage.show();       
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}