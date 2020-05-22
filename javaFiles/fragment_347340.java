public class TestStackedBarChart extends Application {

public static void main(String[] args) {
    launch(args);
}
@Override
public void start(Stage primaryStage) {
    Group root = new Group();

    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();

    xAxis.setLabel("Month");
    xAxis.setCategories(FXCollections.<String> observableArrayList(Arrays.asList(
            "January(Plan)", 
            "January(Actual)",
            "February(Plan)",
            "February(Actual)",
            "March(Plan)",
            "March(Actual)")));
    yAxis.setLabel("Value");


    final StackedBarChart<String,Number> stackedBarChart = new StackedBarChart<>(xAxis,yAxis);
    stackedBarChart.setTitle("StackedBarChart");        

    XYChart.Series<String,Number> series1 = new Series<>();
    series1.setName("Category A");
    series1.getData().add(new Data<>("January(Plan)", Integer.valueOf(100)));
    series1.getData().add(new Data<>("February(Plan)", Integer.valueOf(200)));
    series1.getData().add(new Data<>("March(Plan)", Integer.valueOf(50)));

    XYChart.Series<String,Number> series2 = new Series<>();
    series2.setName("Category B");  
    series2.getData().add(new Data<>("January(Plan)", Integer.valueOf(200)));
    series2.getData().add(new Data<>("February(Plan)", Integer.valueOf(100)));
    series2.getData().add(new Data<>("March(Plan)", Integer.valueOf(25)));        

    XYChart.Series<String,Number> series3 = new Series<>();
    series3.setName("Actual Value");           
    series3.getData().add(new Data<String, Number>("January(Actual)", Integer.valueOf(250)));
    series3.getData().add(new Data<String, Number>("February(Actual)", Integer.valueOf(275)));
    series3.getData().add(new Data<String, Number>("March(Actual)", Integer.valueOf(60)));

    stackedBarChart.getData().add(series1);
    stackedBarChart.getData().add(series2);
    stackedBarChart.getData().add(series3);

    root.getChildren().addAll(stackedBarChart);

    primaryStage.setScene(new Scene(root, 500, 400));
    primaryStage.show();
}
}