import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DragStuff extends Application {

    VBox mainContainer;
    Stage mainSt;

    @Override
    public void start(Stage mainStage) throws Exception {
        // TODO Auto-generated method stub
        mainStage.initStyle(StageStyle.UNDECORATED);
        mainSt = mainStage;
        mainContainer = new VBox();
        mainContainer.setStyle("-fx-background-color:red");

        Label headlineInformation = new Label("Testing");
        headlineInformation.getStyleClass().addAll("popup-label-name");
        headlineInformation.setMaxWidth(Double.MAX_VALUE);

        Button closeButton = new Button("X");
        closeButton.setVisible(true);
        closeButton.getStyleClass()
                .addAll("popup-button", "popup-button-color");

        HBox headContainer = new HBox();
        HBox.setHgrow(headlineInformation, Priority.ALWAYS);
        headContainer.setPadding(new Insets(5, 5, 5, 5));
        headContainer.getChildren().addAll(headlineInformation, closeButton);

        Pane pane = new Pane();
        pane.getChildren()
                .addAll(new Label(
                        "Text                                                                                      Stuff"));

        mainContainer.getChildren().addAll(headContainer, pane);

        Scene sc = new Scene(mainContainer);
        mainStage.setScene(sc);
        mainStage.show();

        dragHandling();

    }

    public void dragHandling() {
        final ObjectProperty<Point2D> mouseKoordinates = new SimpleObjectProperty<>();
        mainContainer.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //Important to create the new Point with a Reference to the Screen!
                mouseKoordinates.set(new Point2D(event.getScreenX(), event
                        .getScreenY()));
                mainContainer.getScene().setCursor(Cursor.HAND);
            };
        });

        mainContainer.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(final MouseEvent arg0) {
                mouseKoordinates.set(null);
                mainContainer.getScene().setCursor(Cursor.DEFAULT);
            }
        });

        mainContainer.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (mouseKoordinates.get() != null) {
                    //getScreenX and not getX
                    double x = event.getScreenX();
                    double deltaX = x - mouseKoordinates.get().getX();
                    //getScreenY and not getY
                    double y = event.getScreenY();
                    double deltaY = y - mouseKoordinates.get().getY();
                    mainSt.setX(mainSt.getX() + deltaX);
                    mainSt.setY(mainSt.getY() + deltaY);
                    //VERY IMPORANT
                    mouseKoordinates.set(new Point2D(x, y));
                }
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}