import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.converter.BigDecimalStringConverter;

public class POJOBindingExample extends Application {

    private TextField nameTextField = new TextField();
    private TextField orderTextField = new TextField();
    private TextField weightTextField = new TextField();
    private TextField commentTextField = new TextField();

    @Override
    public void start(Stage primaryStage) {
        Task task = new Task();
        TaskAdapter adapter = new TaskAdapter(task);
        nameTextField.textProperty().bindBidirectional(adapter.getNameProperty());
        orderTextField.textProperty().bindBidirectional(adapter.getOrderProperty(),new SimpleIntegerStringConverter());
        weightTextField.textProperty().bindBidirectional(adapter.getWeightProperty(),new BigDecimalStringConverter());
        commentTextField.textProperty().bindBidirectional(adapter.getCommentProperty());

        GridPane grid = new GridPane();
        grid.addRow(0, new Label("Name:"), nameTextField);
        grid.addRow(1, new Label("Order:"), orderTextField);
        grid.addRow(2, new Label("Weight:"), weightTextField);
        grid.addRow(3, new Label("Comment:"), commentTextField);

        Button showButton = new Button("Show Task");
        showButton.setOnAction(e -> {
            System.out.println(task.getName());
            System.out.println(task.getOrder());
            System.out.println(task.getWeight());
            System.out.println(task.getComment());
            System.out.println();
        });

        Button gcButton = new Button("Run GC");
        gcButton.setOnAction(e -> System.gc());

        HBox buttons = new HBox(10, showButton, gcButton);

        BorderPane.setAlignment(grid, Pos.CENTER);
        BorderPane.setAlignment(buttons, Pos.CENTER);
        BorderPane.setMargin(grid, new Insets(10));
        BorderPane.setMargin(buttons, new Insets(10));

        BorderPane root = new BorderPane(grid, null, null, buttons, null);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}