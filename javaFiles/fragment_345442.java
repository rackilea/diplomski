import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Axis extends Application
{

    public static void main(final String[] args)
    {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception
    {
        final NumberAxis x = new NumberAxis();
        final NumberAxis y = new NumberAxis();
        x.setAutoRanging(false);
        y.setAutoRanging(false);

        final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(x, y);
        lineChart.setPrefSize(900, 900);
        lineChart.setLegendVisible(false);
        lineChart.setCreateSymbols(false);
        lineChart.setAlternativeColumnFillVisible(false);
        lineChart.setAlternativeRowFillVisible(false);

        final XYChart.Series seriesX = new XYChart.Series();

        for (int i = 1; i < 100; i++) {
            if ((i % 2) != 0) {
                seriesX.getData().add(new XYChart.Data(i, 0));
                seriesX.getData().add(new XYChart.Data(i, 100));
            }
            else {
                seriesX.getData().add(new XYChart.Data(i, 100));
                seriesX.getData().add(new XYChart.Data(i, 0));
            }

        }

        final XYChart.Series seriesY = new XYChart.Series();

        for (int i = 1; i < 100; i++) {
            if ((i % 2) != 0) {
                seriesY.getData().add(new XYChart.Data(0, i));
                seriesY.getData().add(new XYChart.Data(100, i));
            }
            else {
                seriesY.getData().add(new XYChart.Data(100, i));
                seriesY.getData().add(new XYChart.Data(0, i));
            }

        }

        lineChart.getData().add(seriesX);
        lineChart.getData().add(seriesY);
        lineChart.getStylesheets().add("site.css");
        final Scene scene = new Scene(lineChart);
        stage.setScene(scene);
        stage.show();
    }
}