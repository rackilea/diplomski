import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Controller extends StackPane {

    @FXML
    private GridPane container;

    @FXML
    private GridPane topGridPane;

    @FXML
    private StackPane visualizerStackPane;

    @FXML
    private VBox topRightVBox;

    @FXML
    private StackPane mediaFileStackPane;

    @FXML
    private GridPane bottomGridPane;

    // ------------------------------

    ResizableCanvas visualizerCanvas = new ResizableCanvas();

    /**
     * Constructor
     */
    public Controller() {

        // ------------------------FXMLLoader ---------------------------------
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Controller.fxml"));
        loader.setController(this);
        loader.setRoot(this);

        try {
            loader.load();
        } catch (IOException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Controller FXML can't be loaded!", ex);
        }
    }

    /**
     * Called as soon as FXML FILE has been loaded
     */
    @FXML
    private void initialize() {

        visualizerStackPane.getChildren().add(visualizerCanvas);

    }
}