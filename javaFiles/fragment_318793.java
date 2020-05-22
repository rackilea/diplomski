import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CardRefreshButton extends Application {

    List<Image> deck = new ArrayList<>();

    public void load() {
        for (int i = 0; i < 52; i++) {
            deck.add(new Image(getClass().getResource(i + ".png").toExternalForm()));
        }
    }

    @Override
    public void start(Stage primaryStage) {

        load();

        primaryStage.setTitle("Shuffling Deck Program");

        BorderPane bPane1 = new BorderPane();
        HBox pane1 = new HBox(10);
        HBox pane2 = new HBox(10);

        ImageView view0 = new ImageView(deck.get(0));
        ImageView view1 = new ImageView(deck.get(1));
        ImageView view2 = new ImageView(deck.get(2));
        ImageView view3 = new ImageView(deck.get(3));

        Button refresh = new Button("Refresh");

        refresh.setOnAction((event) -> {

            Collections.shuffle( deck);

            view0.setImage(deck.get(0));
            view1.setImage(deck.get(1));
            view2.setImage(deck.get(2));
            view3.setImage(deck.get(3));

        });

        pane1.setAlignment(Pos.CENTER);
        pane2.setAlignment(Pos.CENTER);

        pane1.getChildren().addAll(view0, view1, view2, view3);
        pane2.getChildren().add(refresh);

        bPane1.setCenter(pane1);
        bPane1.setBottom(pane2);

        Scene scene1 = new Scene(bPane1, 600, 650);
        primaryStage.setScene(scene1);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}