package contextmenudemo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ContextMenuDemo extends Application {

    @Override
    public void start(Stage primaryStage) {

        final ContextMenu cm = new ContextMenu();
        cm.addEventFilter(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton() == MouseButton.SECONDARY) {
                    System.out.println("consuming right release button in cm filter");
                    event.consume();
                }
            }
        });
        cm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("right gets consumed so this must be left on "+
                        ((MenuItem)event.getTarget()).getText());
            }
        });

        MenuItem menuItem1 = new MenuItem("line 1");
        MenuItem menuItem2 = new MenuItem("line 2");
        MenuItem menuItem3 = new MenuItem("line 3");

        cm.getItems().addAll(menuItem1, menuItem2, menuItem3);

        final Rectangle rectangle = new Rectangle(70, 70, Color.TAN);
        rectangle.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                if (e.getButton() == MouseButton.SECONDARY) {
                    cm.show(rectangle, e.getScreenX(), e.getScreenY());
                } else {
                    System.out.println("No right click");
                }
            }
        });

        Group root = new Group();
        root.getChildren().addAll(rectangle);
        Scene scene = new Scene(root, 350, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}