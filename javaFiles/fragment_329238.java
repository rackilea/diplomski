import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;

public class Example extends Application {

    public static void main(String args[]) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.focusedProperty().addListener(this::focusChanged);
        stage.setTitle("demo");
        stage.show();
    }

    private void focusChanged(ObservableValue<? extends Boolean> property, Boolean wasFocused, Boolean isFocused) {
        System.out.println("Window changed focus from " + wasFocused + " to " + isFocused);
    }

}