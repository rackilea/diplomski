package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {


    private static Stage mainStage;

    public static Stage getStage() {
        return mainStage;
    }

    @Override
    public void start(Stage stage) throws Exception {

        mainStage = stage;


        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));

        Region contentRootRegion = (Region) loader.load();


        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        double origW = d.width;
        double origH = d.height;

        // Set a default "standard" or "100%" resolution
        // origW = 1360;
        // origH = 700;

        // If the Region containing the GUI does not already have a preferred width and height, set it.
        // But, if it does, we can use that setting as the "standard" resolution.
        if (contentRootRegion.getPrefWidth() == Region.USE_COMPUTED_SIZE)
            contentRootRegion.setPrefWidth(origW);
        else
            origW = contentRootRegion.getPrefWidth();

        if (contentRootRegion.getPrefHeight() == Region.USE_COMPUTED_SIZE)
            contentRootRegion.setPrefHeight(origH);
        else
            origH = contentRootRegion.getPrefHeight();

        //Wrap the resizable content in a non-resizable container (Group)
        Group group = new Group(contentRootRegion);
        //Place the Group in a StackPane, which will keep it centered
        StackPane rootPane = new StackPane();
        rootPane.getChildren().add(group);


        //Create the scene iniitally at the "100%" size
        Scene scene = new Scene(rootPane, origW, origH);
        //Bind the scene's width and height to the scaling parameters on the group
        group.scaleXProperty().bind(scene.widthProperty().divide(origW));
        group.scaleYProperty().bind(scene.heightProperty().divide(origH));
        //Set the scene to the window (stage) and show it

        stage.setTitle("My App Name");

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        stage.setX(bounds.getMinX());
        stage.setY(bounds.getMinY());
        stage.setWidth(bounds.getWidth());
        stage.setHeight(bounds.getHeight());
        stage.setMaximized(true);

        //stage.setFullScreen(true);

        stage.setScene(scene);
        stage.show();
    }


    public static void ChangeScene(String FXML) {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource(FXML));
            Region contentRootRegion = (Region) loader.load();


            Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
            double origW = d.width;
            double origH = d.height;

            if (contentRootRegion.getPrefWidth() == Region.USE_COMPUTED_SIZE)
                contentRootRegion.setPrefWidth(origW);
            else
                origW = contentRootRegion.getPrefWidth();

            if (contentRootRegion.getPrefHeight() == Region.USE_COMPUTED_SIZE)
                contentRootRegion.setPrefHeight(origH);
            else
                origH = contentRootRegion.getPrefHeight();

            //Wrap the resizable content in a non-resizable container (Group)
            Group group = new Group(contentRootRegion);
            //Place the Group in a StackPane, which will keep it centered
            StackPane rootPane = new StackPane();
            rootPane.getChildren().add(group);


            //Create the scene initially at the "100%" size
            Scene scene = new Scene(rootPane, origW, origH);
            //Bind the scene's width and height to the scaling parameters on the group
            group.scaleXProperty().bind(scene.widthProperty().divide(origW));
            group.scaleYProperty().bind(scene.heightProperty().divide(origH));
            //Set the scene to the window (stage) and show it

            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();

            Main.getStage().setX(bounds.getMinX());
            Main.getStage().setY(bounds.getMinY());
            Main.getStage().setWidth(bounds.getWidth());
            Main.getStage().setHeight(bounds.getHeight());
            //Main.getStage().setMaximized(true);

            Main.getStage().setScene(scene);
            Main.getStage().show();


        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}