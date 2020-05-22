import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.imageio.ImageIO;


public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, IOException {

        AnchorPane root = new AnchorPane();

        // replace this PATH_TO_YOUR_IMAGE
        Path get = Paths.get("<PATH_TO_YOUR_IMAGE>");
        byte[] readAllBytes = Files.readAllBytes(get);
        Image convertToJavaFXImage = convertToJavaFXImage(readAllBytes, 1024, 768);
        ImageView view = new ImageView(convertToJavaFXImage);
        root.getChildren().add(view);
        Scene scene = new Scene(root, 1024, 768);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private static Image convertToJavaFXImage(byte[] raw, final int width, final int height) {
        WritableImage image = new WritableImage(width, height);
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(raw);
            BufferedImage read = ImageIO.read(bis);
            image = SwingFXUtils.toFXImage(read, null);
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return image;
    }

}