public class main extends Application {

@Override
public void start(Stage primaryStage) {

    HBox root = new HBox();

    TextField textField = new TextField();

    textField.setOnKeyPressed(e -> {

        if (e.getCode().equals(KeyCode.UP)) {
            textField.end();
            e.consume(); // this stop propagating the event
        }

    }); 

    root.getChildren().add(textField);
    Scene scene = new Scene(root, 300, 300);
    primaryStage.setScene(scene);
    primaryStage.show();
}

public static void main(String[] args) {
    launch(args);
}
}