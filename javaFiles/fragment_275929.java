import javafx.animation.*;
import javafx.application.Application;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RotatingSushiMenu extends Application {

    private static final Duration AUTO_CHANGE_PAUSE = Duration.seconds(2);

    private boolean autoChange;

    @Override
    public void start(Stage stage) {
        ObservableList<Image> images = FXCollections.observableList(
                Arrays.stream(IMAGE_LOCS)
                        .map(Image::new)
                        .collect(Collectors.toList())
        );

        ListView<Image> list = new ListView<>(FXCollections.observableList(images));
        list.setCellFactory(param -> new ImageListCell());

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO),
                new KeyFrame(
                        AUTO_CHANGE_PAUSE,
                        e -> {
                            int curIdx = list.getSelectionModel().getSelectedIndex();
                            if (curIdx < list.getItems().size() - 1) {
                                autoChange = true;
                                list.scrollTo(curIdx + 1);
                                list.getSelectionModel().select(curIdx + 1);
                                autoChange = false;
                            }
                        }
                )
        );
        timeline.setCycleCount(list.getItems().size());

        Button cycle = new Button("Cycle");
        cycle.setOnAction(event -> {
            if (list.getItems().size() > 0) {
                list.scrollTo(0);
                list.getSelectionModel().select(0);
                timeline.playFromStart();
            }
        });

        list.getSelectionModel().getSelectedItems().addListener((ListChangeListener<Image>) c -> {
            if (!autoChange) {
                timeline.stop();
            }
        });

        VBox layout = new VBox(10, cycle, list);
        layout.setPadding(new Insets(10));
        stage.setScene(new Scene(layout));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private class ImageListCell extends ListCell<Image> {
        final ImageView imageView = new ImageView();

        ImageListCell() {
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        }

        @Override
        protected void updateItem(Image item, boolean empty) {
            super.updateItem(item, empty);

            if (empty || item == null) {
                imageView.setImage(null);
                setText(null);
                setGraphic(null);
            }

            imageView.setImage(item);
            setGraphic(imageView);
        }
    }

    // image license: linkware - backlink to http://www.fasticon.com
    private static final String[] IMAGE_LOCS = {
            "http://icons.iconarchive.com/icons/fasticon/fish-toys/128/Blue-Fish-icon.png",
            "http://icons.iconarchive.com/icons/fasticon/fish-toys/128/Red-Fish-icon.png",
            "http://icons.iconarchive.com/icons/fasticon/fish-toys/128/Yellow-Fish-icon.png",
            "http://icons.iconarchive.com/icons/fasticon/fish-toys/128/Green-Fish-icon.png"
    };
}