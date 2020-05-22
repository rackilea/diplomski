package tutoFX;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import net.javainthebox.caraibe.svg.SVGContent;
import net.javainthebox.caraibe.svg.SVGLoader;

public class SVGLoaderSample extends Application {

    @Override
    public void start(Stage stage) {
        SVGContent content = SVGLoader.load(getClass().getResource("arrow-alt-circle-right10.svg").toString());
        // Scale the image and wrap it in a Group to make the button 
        // properly scale to the size of the image  

        content.setScaleX(0.1);
        content.setScaleY(0.1);
        Group graphic = new Group(content);
        // create a button and set the graphics node
        Button button = new Button();
        button.setGraphic(graphic);

        // add the button to the scene and show the scene
        HBox layout = new HBox(button);
        HBox.setMargin(button, new Insets(10));

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.setTitle("SVGLoader Sample");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}