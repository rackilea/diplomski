package jfxfeatures.graphics.image.loading.async;

import java.io.File;
import java.net.MalformedURLException;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AsyncImageDemo extends Application {

    @Override
    public void start(Stage stage) {
        String imgURL = null;
        try {
            final String remoteURL = "http://farm5.staticflickr.com/4129/4960490401_71a3d05d28_o_d.jpg";
            final String remoteURL2 = "http://www.spacetelescope.org/static/archives/posters/large/earth02.jpg";
            final String localURL = new File("data/earth02.jpg").toURI().toURL().toExternalForm();
            final String localFile = "/earth02.jpg";

            //===========================
            // Select local or remote image source.
            imgURL = localFile;
            //===========================
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        }

        StackPane root = new StackPane();
        Scene scene = new Scene(root, 800, 800);
        scene.setFill(Color.BLACK);

        ImageView iv = new ImageView();
        iv.setPreserveRatio(true);
        iv.fitHeightProperty().bind(root.heightProperty());
        iv.fitWidthProperty().bind(root.widthProperty());
        root.getChildren().add(iv);

        stage.setTitle(getClass().getSimpleName());
        stage.setScene(scene);
        stage.show();

        if (imgURL != null) {
            Image image = new Image(imgURL, true);
            image.progressProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    System.out.println("Progress: " + Math.rint(newValue.doubleValue() * 100) + "%");
                }
            });
            iv.setImage(image);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}