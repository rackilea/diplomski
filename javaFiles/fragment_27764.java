import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import javax.imageio.ImageIO;

public class Test {

    public static void main(String[] args) {

        String chartGenLocation = "/Users/work/tmp";
        new JFXPanel();
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Failed", 10),
                        new PieChart.Data("Skipped", 20));
        final PieChart chart = new PieChart(pieChartData);
        chart.setAnimated(false);
        Platform.runLater(() -> {
            Stage stage = new Stage();
            Scene scene = new Scene(chart, 500, 500);
            stage.setScene(scene);
            WritableImage img = new WritableImage(500, 500);
            scene.snapshot(img);

            File file = new File(Paths.get(chartGenLocation, "a.png").toString());
            try {
                ImageIO.write(SwingFXUtils.fromFXImage(img, null), "png", file);
            } catch (IOException e) {
                //logger.error("Error occurred while writing the chart image
            }
        });
    }
}