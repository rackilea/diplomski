import javafx.application.Application;
import javafx.collections.*;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.chart.*;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

public class LineChartSample extends Application {
  @SuppressWarnings("unchecked")
  @Override public void start(Stage stage) {
    // initialize data
    ObservableList<XYChart.Data> data = FXCollections.observableArrayList(
      new XYChart.Data(1, 23),new XYChart.Data(2, 14),new XYChart.Data(3, 15),new XYChart.Data(4, 24),new XYChart.Data(5, 34),new XYChart.Data(6, 36),new XYChart.Data(7, 22),new XYChart.Data(8, 45),new XYChart.Data(9, 43),new XYChart.Data(10, 17),new XYChart.Data(11, 29),new XYChart.Data(12, 25)
    );
    ObservableList<XYChart.Data> reversedData = FXCollections.observableArrayList(
        new XYChart.Data(1, 25), new XYChart.Data(2, 29), new XYChart.Data(3, 17), new XYChart.Data(4, 43), new XYChart.Data(5, 45), new XYChart.Data(6, 22), new XYChart.Data(7, 36), new XYChart.Data(8, 34), new XYChart.Data(9, 24), new XYChart.Data(10, 15), new XYChart.Data(11, 14), new XYChart.Data(12, 23)
    );

    // create charts
    final LineChart<Number, Number> lineChart        = createChart(data);
    final LineChart<Number, Number> reverseLineChart = createChart(reversedData);
    StackPane layout = new StackPane();
    layout.getChildren().setAll(
      lineChart,
      reverseLineChart
    );

    // show the scene.
    Scene scene = new Scene(layout, 800, 600);
    stage.setScene(scene);
    stage.show();

    // make one line chart line green so it is easy to see which is which.
    reverseLineChart.lookup(".default-color0.chart-series-line").setStyle("-fx-stroke: forestgreen;");

    // turn off pick on bounds for the charts so that clicks only register when you click on shapes.
    turnOffPickOnBoundsFor(lineChart);
    turnOffPickOnBoundsFor(reverseLineChart);

    // add a glow when you mouse over the lines in the line chart so that you can see that they are chosen.
    addGlowOnMouseOverData(lineChart);
    addGlowOnMouseOverData(reverseLineChart);
  }

  @SuppressWarnings("unchecked")
  private void turnOffPickOnBoundsFor(Node n) {
    n.setPickOnBounds(false);
    if (n instanceof Parent) {
      for (Node c: ((Parent) n).getChildrenUnmodifiable()) {
        turnOffPickOnBoundsFor(c);
      }
    }
  }

  private void addGlowOnMouseOverData(LineChart<Number, Number> lineChart) {
    // make the first series in the chart glow when you mouse over it.
    Node n = lineChart.lookup(".chart-series-line.series0");
    if (n != null && n instanceof Path) {
      final Path path = (Path) n;
      final Glow glow = new Glow(.8);
      path.setEffect(null);
      path.setOnMouseEntered(new EventHandler<MouseEvent>() {
        @Override public void handle(MouseEvent e) {
          path.setEffect(glow);
        }
      });
      path.setOnMouseExited(new EventHandler<MouseEvent>() {
        @Override public void handle(MouseEvent e) {
          path.setEffect(null);
        }
      });
    }
  }

  private LineChart<Number, Number> createChart(ObservableList<XYChart.Data> data) {
    final NumberAxis xAxis = new NumberAxis();
    final NumberAxis yAxis = new NumberAxis();
    xAxis.setLabel("Number of Month");
    final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
    lineChart.setTitle("Stock Monitoring, 2010");
    XYChart.Series series = new XYChart.Series(data);
    series.setName("My portfolio");
    series.getData().addAll();
    lineChart.getData().add(series);
    lineChart.setCreateSymbols(false);
    lineChart.setLegendVisible(false);
    return lineChart;
  }

  public static void main(String[] args) { launch(args); }
}