import java.util.Arrays;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;


public class Charts extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("stackoverflow.com");
        Group root = new Group();

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel("Month");
        xAxis.setCategories(FXCollections.<String> observableArrayList(Arrays.asList(
                "January", 
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December")));
        yAxis.setLabel("Value");

        final StackedBarChart<String,Number> stackedBarChart = new StackedBarChart<>(xAxis,yAxis);

        stackedBarChart.setTitle("StackedBarChart");

        //Series 1
        XYChart.Series<String,Number> series1 = new XYChart.Series();
        series1.setName("XYChart.Series 1");

        series1.getData().add(new XYChart.Data("January", 100));
        series1.getData().add(new XYChart.Data("February", 200));
        series1.getData().add(new XYChart.Data("March", 50));
        series1.getData().add(new XYChart.Data("April", 75));
        series1.getData().add(new XYChart.Data("May", 110));
        series1.getData().add(new XYChart.Data("June", 300));
        series1.getData().add(new XYChart.Data("July", 111));
        series1.getData().add(new XYChart.Data("August", 30));
        series1.getData().add(new XYChart.Data("September", 75));
        series1.getData().add(new XYChart.Data("October", 55));
        series1.getData().add(new XYChart.Data("November", 225));
        series1.getData().add(new XYChart.Data("December", 99));

        //Series 2
        XYChart.Series<String,Number> series2 = new XYChart.Series();
        series2.setName("XYChart.Series 2");


        series2.getData().add(new XYChart.Data("January", 150));
        series2.getData().add(new XYChart.Data("February", 100));
        series2.getData().add(new XYChart.Data("March", 60));
        series2.getData().add(new XYChart.Data("April", 40));
        series2.getData().add(new XYChart.Data("May", 30));
        series2.getData().add(new XYChart.Data("June", 100));
        series2.getData().add(new XYChart.Data("July", 100));
        series2.getData().add(new XYChart.Data("August", 10));
        series2.getData().add(new XYChart.Data("September", 175));
        series2.getData().add(new XYChart.Data("October", 155));
        series2.getData().add(new XYChart.Data("November", 125));
        series2.getData().add(new XYChart.Data("December", 150));

        //
        stackedBarChart.getData().addAll(series1, series2);      
        root.getChildren().addAll(stackedBarChart);
        primaryStage.setScene(new Scene(root, 500, 400));
        primaryStage.getScene().getStylesheets().add("style.css");
        primaryStage.show();
    }
}