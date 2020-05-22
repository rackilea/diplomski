import java.util.function.Consumer;

import javafx.application.Application;
import javafx.application.Platform;

import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import javafx.scene.shape.Rectangle;

import javafx.util.Duration;
import javafx.util.converter.DoubleStringConverter;

public class AnimatedCells
extends Application {
    @Override
    public void start(Stage stage) {
        ListView<CellData> list = new ListView<>();
        list.setCellFactory(l -> new MyCell());

        TextField secondsField = new TextField();

        Button newTimerButton = new Button("Create");
        newTimerButton.setOnAction(e -> {
            list.getItems().add(
                new CellData(secondsField.getText(),
                    c -> list.getItems().remove(c)));
        });
        secondsField.setOnAction(e -> {
            list.getItems().add(
                new CellData(secondsField.getText(),
                    c -> list.getItems().remove(c)));
        });

        HBox newButtonPane = new HBox(6, secondsField, newTimerButton);
        newButtonPane.setPadding(new Insets(12));

        stage.setScene(new Scene(
            new BorderPane(list, null, null, newButtonPane, null)));
        stage.setTitle("Animated Cells");
        stage.show();
    }

    public static class MyCell extends ListCell<CellData> {
        private CellComponent cc;

        public MyCell() {
            cc = new CellComponent();
        }

        @Override
        protected void updateItem(CellData item, boolean empty) {
            super.updateItem(item, empty);

            if (empty || item == null) {
                setText(null);
                setGraphic(null);
            } else {
                cc.getTimer().textProperty().unbind();
                cc.getTimer().textProperty().bind(
                    item.secondsRemainingProperty().asString("%.0f"));

                cc.getRect().widthProperty().unbind();
                cc.getRect().widthProperty().bind(
                    item.secondsRemainingProperty().multiply(10));

                setText(null);
                setGraphic(cc.getCellPane());
            }
        }
    }

    public static class CellData {
        private final StringProperty data;

        private final ReadOnlyDoubleWrapper secondsRemaining;

        private final Timeline timeline = new Timeline();

        public CellData(Consumer<? super CellData> finished) {
            data = new SimpleStringProperty(this, "data");
            secondsRemaining =
                new ReadOnlyDoubleWrapper(this, "secondsRemaining");

            data.addListener((o, oldData, newData) -> {
                try {
                    double startTime = Double.parseDouble(newData);

                    timeline.stop();

                    timeline.getKeyFrames().setAll(
                        new KeyFrame(Duration.ZERO,
                            new KeyValue(secondsRemaining, startTime)),
                        new KeyFrame(Duration.seconds(startTime),
                            new KeyValue(secondsRemaining, 0.0))
                    );
                    timeline.setOnFinished(e -> finished.accept(this));

                    timeline.play();
                } catch (NumberFormatException e) {
                    System.err.println(
                        "Cannot start timer for invalid seconds value: " + e);
                    Platform.runLater(() -> finished.accept(this));
                }
            });
        }

        public CellData(String data,
                        Consumer<? super CellData> finished) {
            this(finished);
            this.setData(data);
        }

        public StringProperty dataProperty() {
            return data;
        }

        public String getData() {
            return data.get();
        }

        public void setData(String data) {
            this.data.set(data);
        }

        public ReadOnlyDoubleProperty secondsRemainingProperty() {
            return secondsRemaining.getReadOnlyProperty();
        }

        public double getSecondsRemaining() {
            return secondsRemaining.get();
        }
    }

    public static class CellComponent {
        private final Pane cellPane;

        private final Label timer;

        private final Rectangle rect;

        public CellComponent() {
            // For the sake of example, I'm building this in code rather than
            // with FXML.

            //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/listcell.fxml"));
            //fxmlLoader.setController(this);
            //try
            //{
            //    fxmlLoader.load();
            //}
            //catch (IOException e)
            //{
            //    throw new RuntimeException(e);
            //}

            rect = new Rectangle(1, 40);
            rect.setArcWidth(20);
            rect.setArcHeight(20);
            rect.setStyle(
                "-fx-fill: red; -fx-stroke: black; -fx-stroke-width: 2;");
            timer = new Label(" ");
            timer.setStyle("-fx-font-size: 18pt; -fx-alignment: center;");
            cellPane = new HBox(24, timer, rect);
            cellPane.setStyle("-fx-alignment: center-left;");
        }

        public Pane getCellPane() {
            return cellPane;
        }

        public Label getTimer() {
            return timer;
        }

        public Rectangle getRect() {
            return rect;
        }
    }

    public static class Main {
        public static void main(String[] args) {
            Application.launch(AnimatedCells.class, args);
        }
    }
}