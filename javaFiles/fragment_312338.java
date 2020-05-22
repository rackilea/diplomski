import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.awt.geom.GeneralPath;

public class Widget extends JFrame {

    class DragContext { 
        double x;
        double y; 
    } 

    public Widget() {

        // decoration
        setType(Type.UTILITY);
        setUndecorated(true);

        setSize(200, 200);

        toBack();

        // position
        // setLocation(100, 100);
        setLocationRelativeTo(null); // centers on screen

        // frame operations
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // frame shape (a star)
        double points[][] = { { 0, 85 }, { 75, 75 }, { 100, 10 }, { 125, 75 }, { 200, 85 }, { 150, 125 }, { 160, 190 }, { 100, 150 }, { 40, 190 }, { 50, 125 }, { 0, 85 } };
        GeneralPath star = new GeneralPath();
        star.moveTo(points[0][0], points[0][1]);
        for (int k = 1; k < points.length; k++)
            star.lineTo(points[k][0], points[k][2]);
        star.closePath();

        setShape(star);

        // embed fx into swing
        JFXPanel fxPanel = new JFXPanel();

        Widget.this.getContentPane().add(fxPanel);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                // set scene in JFXPanel
                fxPanel.setScene( createFxScene());

                // show frame
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {

                        Widget.this.setVisible(true);

                        // send it to the desktop, behind all other existing windows
                        // Widget.this.toBack();
                        // Widget.this.repaint();
                    }
                });
            }
        });

    }

    private Scene createFxScene() {

        StackPane rootPane = new StackPane();
        rootPane.setBackground(Background.EMPTY);

        // add some node
        Label label = new Label("Bright & Shiny");
        label.setTextFill(Color.RED);

        rootPane.getChildren().add(label);

        // create scene
        Scene scene = new Scene(rootPane);

        // gradient fill
        RadialGradient radialGradient = new RadialGradient( 270, 0.8, 0.5, 0.5, 0.7, true, CycleMethod.NO_CYCLE, new Stop( .5f, Color.YELLOW), new Stop( .7f, Color.ORANGE), new Stop( .9f, Color.ORANGERED));
        scene.setFill(radialGradient);

        // context menu with close button
        ContextMenu contextMenu = new ContextMenu();

        MenuItem closeMenuItem = new MenuItem("Close");
        closeMenuItem.setOnAction(actionEvent -> System.exit(0));

        contextMenu.getItems().add(closeMenuItem);

        // set context menu for scene
        scene.setOnMousePressed(mouseEvent -> {
            if (mouseEvent.isSecondaryButtonDown()) {
                contextMenu.show(rootPane, mouseEvent.getScreenX(), mouseEvent.getScreenY());
            }
        });

        // allow the frame to be dragged around
        final DragContext dragDelta = new DragContext();

        rootPane.setOnMousePressed(mouseEvent -> {

            dragDelta.x = Widget.this.getLocation().getX() - mouseEvent.getScreenX();
            dragDelta.y = Widget.this.getLocation().getY() - mouseEvent.getScreenY();

        });

        rootPane.setOnMouseDragged(mouseEvent -> Widget.this.setLocation((int) (mouseEvent.getScreenX() + dragDelta.x), (int) (mouseEvent.getScreenY() + dragDelta.y)));

        return scene;
    }

    public static void main(String[] args) {
        new Widget();
    }

}