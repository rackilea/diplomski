import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TestingGround extends Application
{

    HBox root = new HBox();

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        BarChart<String, Number> chartA = createChart();
        BarChart<String, Number> chartB = createChart();

        root.getChildren().addAll(chartA, chartB);

        Scene scene = new Scene(root, 400, 200);
        scene.getStylesheets().add("testingground/chartcss.css");
        primaryStage.setScene(scene);
        primaryStage.setHeight(600);
        primaryStage.setWidth(400);
        primaryStage.show();

        populateCharts(chartA, chartB);
    }

    private BarChart<String, Number> createChart()
    {
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis(0, 100, 1);
        yAxis.setTickUnit(1);
        yAxis.setPrefWidth(35);
        yAxis.setMinorTickCount(10);
        yAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(yAxis)
        {
            @Override
            public String toString(Number object)
            {
                String label;
                label = String.format("%7.2f", object.floatValue());
                return label;
            }
        });

        final BarChart<String, Number> chart = new BarChart(xAxis, yAxis);

        chart.setAlternativeRowFillVisible(false);
        chart.setLegendVisible(false);
        chart.setAnimated(false);

        chart.prefWidthProperty().bind(this.root.widthProperty().multiply(0.5));
        chart.prefHeightProperty().bind(this.root.heightProperty());
        chart.minHeightProperty().bind(this.root.heightProperty());

        // Set this so axis bounds can be set manually.
        yAxis.setAutoRanging(false);

        return chart;
    }

    private void populateCharts(BarChart<String, Number> chartA, BarChart<String, Number> chartB)
    {

        XYChart.Series seriesA = new XYChart.Series();

        //data sorted!
        seriesA.getData().add(new XYChart.Data("300", 2.5));
        seriesA.getData().add(new XYChart.Data("305", 4));
        seriesA.getData().add(new XYChart.Data("310", 100));



        chartA.getData().addAll(seriesA);

        XYChart.Series seriesB = new XYChart.Series();
        //sorted data!
        seriesB.getData().add(new XYChart.Data("300", 1));
        seriesB.getData().add(new XYChart.Data("305", 4));
        seriesB.getData().add(new XYChart.Data("310", 2.5));

        chartB.getData().addAll(seriesB);
    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }

}