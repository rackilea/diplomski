import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.css.PseudoClass;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class GridOfCircles extends Application {

    private static final PseudoClass SELECTED_P_C = PseudoClass.getPseudoClass("selected");

    private final int numColumns = 100 ;
    private final int numRows = 100 ;
    private final double radius = 4 ;
    private final double spacing = 2 ;

    private final ObjectProperty<Circle> selectedCircle = new SimpleObjectProperty<>(); 

    private final ObjectProperty<Point2D> selectedLocation = new SimpleObjectProperty<>();

    @Override
    public void start(Stage primaryStage) {

        selectedCircle.addListener((obs, oldSelection, newSelection) -> {
            if (oldSelection != null) {
                oldSelection.pseudoClassStateChanged(SELECTED_P_C, false);
            }
            if (newSelection != null) {
                newSelection.pseudoClassStateChanged(SELECTED_P_C, true);
            }
        });

        Pane grid = new Pane();

        for (int x = 0 ; x < numColumns; x++) {
            double gridX = x*(spacing + radius + radius) + spacing ;
            grid.getChildren().add(new Line(gridX, 0, gridX, numRows*(spacing + radius + radius)));
        }

        for (int y = 0; y < numRows ; y++) {
            double gridY = y*(spacing + radius + radius) + spacing ;
            grid.getChildren().add(new Line(0, gridY, numColumns*(spacing + radius + radius), gridY));
        }

        for (int x = 0 ; x < numColumns; x++) {
            for (int y = 0 ;y < numRows ; y++) {
                grid.getChildren().add(createCircle(x, y));
            }
        }


        Label label = new Label();
        label.textProperty().bind(Bindings.createStringBinding(() -> {
            Point2D loc = selectedLocation.get();
            if (loc == null) {
                return "" ;
            }
            return String.format("Location: [%.0f, %.0f]", loc.getX(), loc.getY());
        }, selectedLocation));

        BorderPane root = new BorderPane(new ScrollPane(grid));
        root.setTop(label);


        Scene scene = new Scene(root);
        scene.getStylesheets().add("grid.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Circle createCircle(int x, int y) {
        Circle circle = new Circle();
        circle.getStyleClass().add("intersection");
        circle.setCenterX(x * (spacing + radius + radius) + spacing);
        circle.setCenterY(y * (spacing + radius + radius) + spacing);
        circle.setRadius(radius);

        circle.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            selectedCircle.set(circle);
            selectedLocation.set(new Point2D(x, y));
        });

        return circle ;
    }

    public static void main(String[] args) {
        launch(args);
    }
}