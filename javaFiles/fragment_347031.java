package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    public void start(Stage primaryStage) throws Exception {
        HBox OuterHBox = new HBox();

        Image image1 = new Image("file:resources/redseven.png", 200, 200, true, true);
        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitWidth(200);
        imageView1.setFitHeight(200);
        imageView1.setPreserveRatio(true);
        // imageView1.fitWidthProperty().bind(OuterHBox.widthProperty());
        imageView1.fitHeightProperty().bind(OuterHBox.heightProperty());

        Image image2 = new Image("file:resources/redseven.png", 200, 200, true, true);
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitWidth(200);
        imageView2.setFitHeight(200);
        imageView2.setPreserveRatio(true);
        // imageView1.fitWidthProperty().bind(OuterHBox.widthProperty());
        imageView2.fitHeightProperty().bind(OuterHBox.heightProperty());
        // Updated Code============
        OuterHBox.widthProperty().addListener((observable, oldValue, newValue) -> {

            imageView1.setFitWidth(newValue.doubleValue() / 2);
            imageView2.setFitWidth(newValue.doubleValue() / 2);
        });
        OuterHBox.getChildren().addAll(imageView1, imageView2);

        Scene scene = new Scene(OuterHBox, 600, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void loadFontStuff() {
        Font.loadFont(Main.class.getResource("TRON.TTF").toExternalForm(), 10);
        System.out.println(Main.class.getResource("TRON.TTF"));

    }
}