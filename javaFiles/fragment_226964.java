import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage stage) {
        HBox hbox = new HBox();

        ImageView imageView1 = new ImageView(new Image(Main.class.getResourceAsStream("/image.png")));
        ImageView imageView2 = new ImageView(new Image(Main.class.getResourceAsStream("/image.png")));
        hbox.getChildren().add(imageView1);
        hbox.getChildren().add(imageView2);

        Lighting lighting = new Lighting();
        lighting.setDiffuseConstant(1.0);
        lighting.setSpecularConstant(0.0);
        lighting.setSpecularExponent(0.0);
        lighting.setSurfaceScale(0.0);
        lighting.setLight(new Light.Distant(45, 45, Color.GREEN));

        imageView2.setEffect(lighting);

        stage.setScene(new Scene(hbox));
        stage.sizeToScene();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}