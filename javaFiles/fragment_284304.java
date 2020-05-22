import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MyClass extends Application {
    private static String myVariable;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        setMyVariable("Anything");
        URL location = getClass().getResource("MyGui.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(location);
        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
        Parent root = FXMLLoader.load(location);
        Scene scene = new Scene(root);
        stage.setTitle("Hello Word");
        stage.setScene(scene);
        stage.show();
    }

    public static String getMyVariable() {
        return myVariable;
    }

    public static void setMyVariable(String myVariable) {
        MyClass.myVariable = myVariable;
    }

}