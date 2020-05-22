package rbexample;

    import javafx.application.Application;
    import javafx.event.ActionEvent;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.control.RadioButton;
    import javafx.scene.layout.VBox;
    import javafx.stage.Stage;

    public class RBExample extends Application {
        RadioButton rBtn;
        Button btn;

    @Override
    public void start(Stage primaryStage) {
        rBtn = new RadioButton();
        rBtn.setText("Select Me");
        rBtn.setOnAction(this::handleRBSelectedAction);
        btn = new Button();
        btn.setText("Push Me");
        btn.setOnAction(this::handleBPushedAction);

        VBox root = new VBox(2);
        root.getChildren().add(rBtn);
        root.getChildren().add(btn);
        Scene scene = new Scene(root, 150, 50);
        primaryStage.setTitle("RBExample");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleRBSelectedAction(ActionEvent event) {
        if (rBtn.isSelected()) {
            System.out.println("RB Selected directly");
        }
    }
    private void handleBPushedAction(ActionEvent event) {
        rBtn.setSelected(true);
        System.out.println("RB Selected by button");
    }

    public static void main(String[] args) {
        launch(args);
    }
}