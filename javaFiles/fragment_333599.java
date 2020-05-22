package sample;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller {

    @FXML
    private PieChart pieChart;
    @FXML
    private TextField pathField;
    @FXML
    private Label subfolder;
    @FXML
    private Button up;
    @FXML
    private Button hide;
    @FXML
    private Button showHidden;
    @FXML
    private VBox field1;
    @FXML
    private VBox field2;
    @FXML
    private VBox field3;
    @FXML
    private VBox field4;
    @FXML
    private AnchorPane parentContainer;
    @FXML
    private ProgressIndicator loading;

    private ObservableList<PieChart.Data> pieChartData;
    private Calc calc;
    public File directory;
    String[] unit = {"Bytes", "KB", "MB", "GB", "TB", "PB", "ZB", "EB"};
    int units = 0;
    boolean hideSegment = false;
    String[] hiddenPath = new String[500];
    double[] hiddenSize = new double[500];
    int Stelle = 499;
    boolean first = true;

    @FXML
    void initialize() {
        pieChartData = FXCollections.observableArrayList();
        calc = new Calc(pieChartData);
        updataLabads();
        pieChart.setData(pieChartData);
    }

    @FXML
    private void handleBrowse() {
        Stage stage = new Stage();
        final DirectoryChooser dirChooser = new DirectoryChooser();
        directory = dirChooser.showDialog(stage);
        if (directory != null) {
            pathField.setText(directory.toString());
        }
    }

    @FXML
    private void apply() {
        loading.setVisible(true);

        Task<Void> applyTask = new Task<Void>() {

            @Override
            protected Void call() throws Exception {

                Thread.sleep(3000);//sleep for 3 seconds just to show that the progress indicator is working

                directory = Paths.get(pathField.getText()).toFile();
                if (directory != null) {
                    //fx-parts need to be executed by Platform.runLater(...)
                    Platform.runLater(() -> pieChartData.clear());

                    String strings = new String(pathField.getText());
                    calc.calcSubfoldersSize(strings);

                    //again let fx-parts be executed in the fx-application-thread
                    Platform.runLater(() -> updataLabads());
                }

                return null;
            }
        };

        applyTask.setOnSucceeded(e -> loading.setVisible(false));
        applyTask.setOnFailed(e -> loading.setVisible(false));//handle error here...

        new Thread(applyTask, "Apply thread").start();

        //loading.setVisible(false); //done when the task ends
    }

    public void updataLabads() {
        pieChart.getData().forEach(data -> {
            data.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {

                for (int i = 0; (data.getPieValue() / (Math.pow(1024, i))) > 1000; i++) {
                    //System.out.println(i);
                    units = i + 1;
                }
                subfolder.setText(data.getName() + ", " + Math.round(data.getPieValue() / (Math.pow(1024, units))) + " " + unit[units]);
                //System.out.println(Math.round(data.getPieValue()/(Math.pow(1024,units))) + " " + unit[units]);
            });
        });
        pieChart.getData().forEach(data -> {
            data.getNode().addEventHandler(MouseEvent.MOUSE_RELEASED, e -> {
                if (hideSegment == false) {
                    pathField.setText(pathField.getText() + "\\" + data.getName());
                    apply();
                }
                else if (hideSegment == true) {
                    pieChartData.remove(data);
                    hideSegment = false;
                    if (first == true) {
                        first = false;
                        Stelle = 0;
                    }
                    hiddenPath[Stelle] = data.getName();
                    hiddenSize[Stelle] = data.getPieValue();
                    System.out.println("Hidden Variables have been updatet on Port " + Stelle);
                    Stelle++;
                    pieChart.setData(pieChartData);
                }
            });
        });
    }

    @FXML
    private void up() {
        while (!pathField.getText().substring(pathField.getText().length() - 1).equals("\\")) {
            pathField.setText(pathField.getText().substring(0, pathField.getText().length() - 1));
        }
        pathField.setText(pathField.getText().substring(0, pathField.getText().length() - 1));
        apply();
    }

    @FXML
    public void hide() {
        if (hideSegment == false)
            hideSegment = true;
        else if (hideSegment == true)
            hideSegment = false;
    }

    @FXML
    public void showHidden() {
        System.out.println("Tried to load HiddenVariables on Port " + (Stelle - 1));
        System.out.println(hiddenPath[Stelle - 1] + "   " + hiddenSize[Stelle - 1]);
        if (!hiddenPath[Stelle - 1].equals(null)) {
            for (int i = Stelle; i != 0; i--) {
                pieChartData.add(new PieChart.Data(hiddenPath[Stelle - 1], hiddenSize[Stelle - 1]));
                hiddenPath[Stelle - 1] = "";
                hiddenSize[Stelle - 1] = 0;
                Stelle--;
                pieChart.setData(pieChartData);
                updataLabads();
            }
        }
    }

    @FXML
    public void Home() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = up.getScene();
        root.translateYProperty().set(scene.getHeight());
        parentContainer.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_BOTH);
        KeyFrame kf = new KeyFrame(Duration.seconds(.5), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
        parentContainer.getChildren().remove(parentContainer);
    }

    @FXML
    public void Files() {}

    @FXML
    public void Settings() {}

    @FXML
    public void Close() {
        Platform.exit();
    }
}