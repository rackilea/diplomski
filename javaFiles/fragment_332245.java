import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;

public class SnapshotChart extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Line Chart Sample");        
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel("Number of Month");
        yAxis.setLabel("Count");
        final LineChart<Number, Number> lineChart =  new LineChart<>(xAxis,yAxis); 
        lineChart.setAnimated(false);
        Scene scene  = new Scene(lineChart,1000,700);


        lineChart.setTitle("Stock Monitoring, 2010");
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("My portfolio");

        series.getData().add(new XYChart.Data<>(1, 23));
        series.getData().add(new XYChart.Data<>(2, 14));
        series.getData().add(new XYChart.Data<>(3, 15));
        series.getData().add(new XYChart.Data<>(4, 24));
        series.getData().add(new XYChart.Data<>(5, 34));
        series.getData().add(new XYChart.Data<>(6, 36));
        series.getData().add(new XYChart.Data<>(7, 22));
        lineChart.getData().add(series);        

        lineChart.applyCss();
        lineChart.layout();         

        stage.setScene(scene);
        stage.show();
        WritableImage img = new WritableImage(1000, 700); 
        File file = new File("saved.png");      
        scene.snapshot(img);        
        RenderedImage renderedImage = SwingFXUtils.fromFXImage(img, null);        
        ImageIO.write(renderedImage,"png", file);  
    }

    public static void main(String[] args) {
        launch(args);
    }
}