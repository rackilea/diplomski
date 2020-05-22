import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.effect.Reflection;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class LabelWidget extends JFrame {

    class DragContext { 
        double x;
        double y; 
    } 

    public LabelWidget() {

        // decoration
        setType(Type.UTILITY);
        setUndecorated(true);

        // make frame transparent, we only want the control to be visible
        setBackground(new java.awt.Color(0,0,0,0));

        setSize(400, 400);

        // position
        // setLocation(100, 100);
        setLocationRelativeTo(null); // centers on screen

        // frame operations
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // embed fx into swing
        JFXPanel fxPanel = new JFXPanel();

        LabelWidget.this.getContentPane().add(fxPanel);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                // set scene in JFXPanel
                fxPanel.setScene( createFxScene());

                // show frame
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {

                        LabelWidget.this.setVisible(true);

                        // send it to the desktop, behind all other existing windows
                        // ClockWidget.this.toBack();
                        // ClockWidget.this.repaint();
                    }
                });
            }
        });

    }

    private Scene createFxScene() {

        StackPane rootPane = new StackPane();

        //  make pane transparent, we only want the control to be visible
        rootPane.setBackground(Background.EMPTY);

        // add control
        Control control = createFxControl();
        rootPane.getChildren().add( control);

        // create scene
        Scene scene = new Scene(rootPane);

        // make scene transparent, we only want the control to be visible
        scene.setFill( Color.TRANSPARENT);

        // context menu with close button
        ContextMenu contextMenu = new ContextMenu();

        MenuItem closeMenuItem = new MenuItem("Close");
        closeMenuItem.setOnAction(actionEvent -> System.exit(0));

        contextMenu.getItems().add(closeMenuItem);

        control.setContextMenu(contextMenu);

        // allow the frame to be dragged around
        makeDraggable( control);

        // allow zooming
        makeZoomable( control);

        return scene;
    }
    /**
     * Create the JavaFX control of which we use the shape.
     * @return
     */
    private Control createFxControl() {

        Label label = new Label( "I'm a Label");
        label.setFont(new Font("Tahoma", 24));
        label.setEffect(new Reflection());

        return label;
    }



    /**
     * Allow dragging of the stage / control on the desktop
     * @param control
     * @param stage
     */
    public void makeDraggable( Control control) {

        final DragContext dragDelta = new DragContext();

        control.setOnMousePressed(mouseEvent -> {

            dragDelta.x = LabelWidget.this.getLocation().getX() - mouseEvent.getScreenX();
            dragDelta.y = LabelWidget.this.getLocation().getY() - mouseEvent.getScreenY();

        });

        control.setOnMouseDragged(mouseEvent -> LabelWidget.this.setLocation((int) (mouseEvent.getScreenX() + dragDelta.x), (int) (mouseEvent.getScreenY() + dragDelta.y)));

    }

    /**
     * Allow zooming
     * @param control
     */
    public void makeZoomable( Control control) {

        // note: in order to make it larger, we'd have to resize the stage/frame => we limit the size to 1.0 for now and allow only making the control smaller
        final double MAX_SCALE = 1.0;
        final double MIN_SCALE = 0.1;
        control.addEventFilter(ScrollEvent.ANY, new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
                double delta = 1.2;
                double scale = control.getScaleX();
                if (event.getDeltaY() < 0) {
                    scale /= delta;
                } else {
                    scale *= delta;
                }
                scale = clamp(scale, MIN_SCALE, MAX_SCALE);
                control.setScaleX(scale);
                control.setScaleY(scale);
                event.consume();
            }
        });

    }

    /**
     * Limit bounds of value
     * @param value
     * @param min
     * @param max
     * @return
     */
    public static double clamp( double value, double min, double max) {
        if( Double.compare(value, min) < 0)
            return min;
        if( Double.compare(value, max) > 0)
            return max;
        return value;
    }

    public static void main(String[] args) {
        new LabelWidget();
    }

}