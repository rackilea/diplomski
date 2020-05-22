import javafx.application.Application;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class BindingsProblem extends Application {

    IntegerProperty boundNumberProperty;

    @Override
    public void start(Stage primaryStage) {
        // Initialization...
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Binding - The problem occurrs here!
        NumberBinding currentWidthPlusTen = primaryStage.widthProperty()
                .add(10);

        boundNumberProperty = new SimpleIntegerProperty();
        boundNumberProperty.bind(currentWidthPlusTen);
        boundNumberProperty.addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                System.out.println(newValue.toString());
            }

        });

    }

    public static void main(String[] args) {
        launch(args);
    }

}