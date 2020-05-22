import org.controlsfx.dialog.Dialogs;
import javafx.application.Application;
import javafx.stage.Stage;

public class Diag extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Dialogs.create()
        .owner(primaryStage)
        .title("Information Dialog")
        .masthead("Look, an Information Dialog")
        .message("I have a great message for you!")
        .showInformation();
    }
    public static void main(String[] args) {
        launch(args);
    }

}