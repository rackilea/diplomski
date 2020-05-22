import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class DraggableStretchableNodeExample extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        Rectangle rect = new Rectangle(50, 50, 50, 50);
        rect.setFill(Color.CORNFLOWERBLUE);

        Tooltip tooltip = new Tooltip("Drag to move, Z+Drag to stretch");
        Tooltip.install(rect, tooltip);

        root.getChildren().add(rect);

        enableDragging(rect);

        Scene scene = new Scene(root,400,400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void enableDragging(Rectangle rect) {

        // A mutable struct-like nested class for the last known mouse location:
        class MouseLocation { 
            double x, y ; 
            void set(double x, double y) {
                this.x=x ;
                this.y=y ;
            }
        }
        MouseLocation mouseLocation = new MouseLocation();

        // Another for the 'Z' key state:
        class Zstate {
            boolean pressed ;
        }
        Zstate zState = new Zstate();

        rect.setOnMousePressed(event -> mouseLocation.set(event.getX(), event.getY()));
        rect.setOnMouseDragged(event -> {
            if (zState.pressed) {
                stretch(rect, event.getX(), event.getY(), event.getX()-mouseLocation.x, event.getY()-mouseLocation.y);
            } else {
                move(rect, event.getX()-mouseLocation.x, event.getY()-mouseLocation.y);
            }
            mouseLocation.set(event.getX(), event.getY());
        });

        rect.setFocusTraversable(true);
        rect.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.Z) {
                zState.pressed = true ;
            }
        });
        rect.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.Z) {
                zState.pressed = false ;
            }
        });

    }

    private void stretch(Rectangle rect, double x, double y, double deltaX, double deltaY) {

        if (x < rect.getX() + rect.getWidth() / 2) {
            // if the mouse is in the left half, stretch left by adjusting x and width:
            rect.setX(rect.getX() + deltaX);
            rect.setWidth(rect.getWidth() - deltaX);
        } else {
            // if in the right half, just stretch by adjusting the width:
            rect.setWidth(rect.getWidth() + deltaX);
        }

        // same vertically:
        if (y <rect.getY() + rect.getHeight() / 2) {
            rect.setY(rect.getY() + deltaY);
            rect.setHeight(rect.getHeight() - deltaY);
        } else {
            rect.setHeight(rect.getHeight() + deltaY);
        }

    }

    private void move(Rectangle rect, double deltaX, double deltaY) {
        rect.setX(rect.getX()+deltaX);
        rect.setY(rect.getY()+deltaY);
    }

    public static void main(String[] args) {
        launch(args);
    }
}