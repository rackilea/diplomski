import javafx.animation.*;
import javafx.application.Application;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.List;
import java.util.stream.*;

public class NumberSwitcher extends Application {

    private static final int NUM_NUMS_DISPLAYED = 3;
    private static final Duration TRANSITION_TIME = Duration.seconds(0.5);

    private final IntegerProperty idx   = new SimpleIntegerProperty(0);
    private final IntegerProperty toIdx = new SimpleIntegerProperty(0);

    private final List<Label> labels =
            IntStream.range(0, NUM_NUMS_DISPLAYED)
                    .mapToObj(
                            this::createLabel
                    )
                    .collect(Collectors.toList());

    private final Button incrementButton = new Button("Increment");

    @Override
    public void start(Stage stage) {
        stage.setScene(
                new Scene(
                        createLayout(),
                        Color.PALEGREEN
                )
        );
        stage.show();

        enableTransitions();
    }

    private StackPane createLayout() {
        incrementButton.setStyle("-fx-base: darkslateblue; -fx-text-fill: papayawhip; -fx-font-size: 20px;");

        HBox numbers = new HBox(10);
        numbers.getChildren().addAll(labels);
        numbers.setPadding(new Insets(15));
        numbers.setMaxWidth(HBox.USE_PREF_SIZE);

        VBox layout = new VBox(
                15,
                numbers,
                incrementButton
        );
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(15));
        layout.setStyle("-fx-background-color: null;");

        StackPane centered = new StackPane(layout);
        centered.setStyle("-fx-background-color: null;");
        return centered;
    }

    private Label createLabel(final int i) {
        Label label = new Label();
        label.setStyle(
                "-fx-font-size: 50px; -fx-font-family: monospace; -fx-text-fill: midnightblue;"
        );

        label.textProperty().bind(new StringBinding() {
            {
                super.bind(idx);
            }

            @Override
            protected String computeValue() {
                return "" + ((idx.get() + i) % 10);
            }
        });

        return label;
    }

    private void enableTransitions() {
        ParallelTransition changeNumbers = new ParallelTransition(
                createFadeFirst()
        );

        IntStream.range(1, labels.size())
                .mapToObj(this::createMoveLeft)
                .forEachOrdered(
                        moveLeft -> changeNumbers.getChildren().add(moveLeft)
                );

        changeNumbers.setOnFinished(e -> idx.set(toIdx.get()));

        toIdx.addListener((observable, oldValue, newValue) ->
                changeNumbers.play()
        );

        // You can disable incrementing while the transition is running,
        // but that is kind of annoying, so I chose not to.
//        incrementButton.disableProperty().bind(
//                changeNumbers.statusProperty().isEqualTo(
//                        PauseTransition.Status.RUNNING
//                )
//        );

        incrementButton.setOnAction(e -> {
            if (idx.get() != toIdx.get()) {
                idx.set(toIdx.get());
            }

            toIdx.set((toIdx.get() + 1) % 10);
        });
    }

    private FadeTransition createFadeFirst() {
        FadeTransition fadeFirst = new FadeTransition(
                TRANSITION_TIME,
                labels.get(0)
        );
        fadeFirst.setFromValue(1);
        fadeFirst.setToValue(0);
        fadeFirst.setOnFinished(e -> labels.get(0).setOpacity(1));
        return fadeFirst;
    }

    private TranslateTransition createMoveLeft(int i) {
        TranslateTransition moveLeft = new TranslateTransition(
                TRANSITION_TIME,
                labels.get(i)
        );
        double dx =
                labels.get(i).getBoundsInParent().getMinX()
                        - labels.get(i-1).getBoundsInParent().getMinX();

        moveLeft.setFromX(0);
        moveLeft.setToX(-dx);
        moveLeft.setOnFinished(e -> labels.get(i).setTranslateX(0));

        return moveLeft;
    }

    public static void main(String[] args) {
        launch(args);
    }

}