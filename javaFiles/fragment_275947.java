import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class MyJavaFXProgram  {

    private StackPane view ;

    public MyJavaFXProgram() {
        Text oText = new Text("My JavaFXProgram");

        view = new StackPane();
        view.getChildren().add(oText);

    }

    public Parent getView() {
        return view ;
    }

}