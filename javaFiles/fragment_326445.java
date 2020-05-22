import javafx.animation.*;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.*;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MetroGnome extends Application {
    public void start(Stage stage) {
        Metronome metronome = new Metronome();
        TempoControl tempoControl = new TempoControl(metronome);
        BeatIndicator beatIndicator = new BeatIndicator(metronome);
        PlayControl playControl = new PlayControl(metronome);

        HBox layout = new HBox(10, playControl, tempoControl, beatIndicator);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10));

        stage.setScene(new Scene(layout));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class PlayControl extends ToggleButton {
    public PlayControl(Metronome metronome) {
        super("Start");

        setOnAction(event -> {
            if (isSelected()) {
                metronome.start();
                setText("Stop");
            } else {
                metronome.stop();
                setText("Start");
            }
        });
    }
}

class TempoControl extends VBox {
    private static final int MIN_TEMPO = 20;
    private static final int MAX_TEMPO = 240;
    private static final int DEFAULT_TEMPO = 120;

    private Slider tempoSlider = new Slider(MIN_TEMPO, MAX_TEMPO, DEFAULT_TEMPO);
    private Label tempoLabel = new Label(tempoSlider.getValue() + "");

    public TempoControl(Metronome metronome) {
        super(5);

        tempoLabel.textProperty().bind(Bindings.format("%.0f", tempoSlider.valueProperty()));
        setAlignment(Pos.CENTER);
        getChildren().setAll(tempoLabel, tempoSlider);

        metronome.setTempo(tempoSlider.getValue());
        metronome.tempoProperty().bind(tempoSlider.valueProperty());
    }

    public DoubleProperty valueProperty() {
        return tempoSlider.valueProperty();
    }
}

class BeatIndicator extends Circle {
    // Ting sound from: http://soundbible.com/1628-Ting.html
    private static final String TING_SOUND = "Ting-Popup_Pixels-349896185.wav";

    private static AudioClip ting = new AudioClip(
            BeatIndicator.class.getResource(TING_SOUND).toExternalForm()
    );

    public BeatIndicator(Metronome metronome) {
        super(10, Color.RED);
        ChangeListener<Beat> beatChangeListener = (observable, oldValue, newValue) -> {
            ting.play();
            setFill(newValue.getTickTock() == 0 ? Color.GREEN : Color.ORANGE);
        };

        DropShadow dropShadow = new DropShadow(5, (Color) getFill());
        fillProperty().addListener((observable, oldValue, newValue) ->
                dropShadow.setColor((Color) newValue)
        );

        Glow beatEffect = new Glow();
        beatEffect.setInput(dropShadow);

        metronome.isRunningProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                setFill(Color.GREEN);
                setEffect(beatEffect);
                metronome.beatProperty().addListener(beatChangeListener);
            } else {
                metronome.beatProperty().removeListener(beatChangeListener);
                setFill(Color.RED);
                setEffect(null);
            }
        });
    }
}

class Metronome {
    private final double DEFAULT_TEMPO = 60;
    private ReadOnlyObjectWrapper<Beat> beat = new ReadOnlyObjectWrapper<>(null);

    private Timeline timeline = new Timeline();

    // tempo is measured in beats per minute.
    private DoubleProperty tempo = new SimpleDoubleProperty(DEFAULT_TEMPO);
    private ReadOnlyBooleanWrapper isRunning = new ReadOnlyBooleanWrapper(false);

    private int tickTock = 0;

    public Metronome() {
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.seconds(0), event -> {
                    beat.set(new Beat(tickTock, timeline.getCurrentTime()));
                    tickTock = (tickTock + 1) % 2;
                }),
                new KeyFrame(
                        Duration.seconds(1)
                )
        );

        tempo.addListener((observable, oldValue, newValue) ->
                timeline.setRate(newValue.doubleValue() / 60.0)
        );
        timeline.setRate(tempo.getValue() / 60.0);
        timeline.setCycleCount(Timeline.INDEFINITE);
    }

    public void start() {
        tickTock = 0;
        isRunning.set(true);
        timeline.playFromStart();
    }

    public void stop() {
        timeline.stop();
        isRunning.set(false);
    }

    public double getTempo() {
        return tempo.get();
    }

    public DoubleProperty tempoProperty() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo.set(tempo);
    }

    public ReadOnlyObjectProperty<Beat> beatProperty() {
        return beat.getReadOnlyProperty();
    }

    public ReadOnlyBooleanProperty isRunningProperty() {
        return isRunning.getReadOnlyProperty();
    }
}

class Beat {
    private final Duration currentTime;
    // tickTock varies switches from one to zero on alternate generated beats.
    private final int tickTock;

    public Beat(int tickTock, Duration currentTime) {
        this.currentTime = currentTime;
        this.tickTock = tickTock;
    }

    public int getTickTock() {
        return tickTock;
    }

    public Duration getCurrentTime() {
        return currentTime;
    }
}