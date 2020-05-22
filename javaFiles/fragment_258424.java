import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class LineChartWithFormattedNumbers extends Application {

    @Override
    public void start(Stage primaryStage) {
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();

        NumberFormat format = new DecimalFormat("#.#E0");
        yAxis.setTickLabelFormatter(new StringConverter<Number>() {

            @Override
            public String toString(Number number) {
                return format.format(number.doubleValue());
            }

            @Override
            public Number fromString(String string) {
                try {
                    return format.parse(string);
                } catch (ParseException e) {
                    e.printStackTrace();
                    return 0 ;
                }
            }

        });

        xAxis.setLabel("Number of Month");
        //creating the chart
        final LineChart<Number,Number> lineChart = 
                new LineChart<Number,Number>(xAxis,yAxis);

        lineChart.setTitle("Stock Monitoring, 2010");
        //defining a series
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("My portfolio");
        //populating the series with data
        series.getData().add(new XYChart.Data<>(1, 23e10));
        series.getData().add(new XYChart.Data<>(2, 14e9));
        series.getData().add(new XYChart.Data<>(3, 15e10));
        series.getData().add(new XYChart.Data<>(4, 24e9));
        series.getData().add(new XYChart.Data<>(5, 34e10));
        series.getData().add(new XYChart.Data<>(6, 36e10));
        series.getData().add(new XYChart.Data<>(7, 22e10));
        series.getData().add(new XYChart.Data<>(8, 45e10));
        series.getData().add(new XYChart.Data<>(9, 43e10));
        series.getData().add(new XYChart.Data<>(10, 17e10));
        series.getData().add(new XYChart.Data<>(11, 29e10));
        series.getData().add(new XYChart.Data<>(12, 25e10));

        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}