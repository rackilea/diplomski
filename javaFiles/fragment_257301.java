import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Example extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Cell cell = new Cell();

        CellRepresentation cellRep = new CellRepresentation(cell);

        Group group = new Group(cellRep);

        ComboBox<Integer> sizeCombo = new ComboBox<>();
        sizeCombo.getItems().addAll(0, 1, 2);

        Shape shape = new Shape();
        shape.sizeProperty().bind(sizeCombo.valueProperty());


        CheckBox showShape = new CheckBox("Show shape");
        cell.shapeProperty().bind(Bindings.when(showShape.selectedProperty()).then(shape).otherwise((Shape)null));

        HBox controls = new HBox(5, showShape, sizeCombo);
        controls.setPadding(new Insets(5));

        BorderPane root = new BorderPane(group, controls, null, null, null);
        root.setBackground(null);

        Scene scene = new Scene(root, 400, 400, Color.AQUA);
        stage.setScene(scene);
        stage.show();
    }
}