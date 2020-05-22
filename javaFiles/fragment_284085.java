import javafx.application.Application;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Map;
import java.util.stream.Collectors;

public class LabeledList extends Application {

    private static final double IMAGE_HEIGHT = 36;

    private static final String SHORT_PREFIX =
            "bird";

    private static final String LONG_PREFIX =
            "http://icons.iconarchive.com/icons/jozef89/origami-birds/72/" + SHORT_PREFIX;

    private static final String SUFFIX =
            "-icon.png";

    private static final ObservableList<String> birds = FXCollections.unmodifiableObservableList(
            FXCollections.observableArrayList(
                "-black",
                "-blue",
                "-red",
                "-red-2",
                "-yellow",
                "s-green",
                "s-green-2"
            )
    );

    private Map<String, Image> imageCollection;

    @Override
    public void start(Stage stage) throws Exception {
        imageCollection = birds.stream().collect(
                Collectors.toMap(
                        bird -> bird,
                        bird -> new Image(
                                        constructLabel(LONG_PREFIX, bird, SUFFIX),
                                        0,
                                        IMAGE_HEIGHT,
                                        true,
                                        true
                                )
                )
        );

        ListView<String> birdList = new ListView<>(birds);
        birdList.setCellFactory(param -> new BirdCell());
        birdList.setPrefWidth(230);
        birdList.setPrefHeight(200);

        VBox layout = new VBox(birdList);
        layout.setPadding(new Insets(10));

        stage.setScene(new Scene(layout));
        stage.show();
    }

    public static void main(String[] args) {
        launch(LabeledList.class);
    }

    private class BirdCell extends ListCell<String> {
        private ImageView imageView = new ImageView();

        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            if (empty || item == null) {
                imageView.setImage(null);

                setGraphic(null);
                setText(null);
            } else {
                imageView.setImage(
                        imageCollection.get(
                                item
                        )
                );

                setText(constructLabel(SHORT_PREFIX, item, SUFFIX));
                setGraphic(imageView);
            }
        }
    }

    private String constructLabel(String prefix, String bird, String suffix) {
        return (prefix != null ? prefix : "")
                + bird
                + (suffix != null ? suffix : "");
    }

    // Iconset Homepage: http://jozef89.deviantart.com/art/Origami-Birds-400642253
    // License: CC Attribution-Noncommercial-No Derivate 3.0
    // Commercial usage: Not allowed    

}