import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

/**
 *
 * @author blj0011
 */
public class JavaFXApplication250 extends Application
{

    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Line Chart Sample");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of Month");
        //creating the chart
        final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);

        lineChart.setTitle("Stock Monitoring, 2010");
        //defining a series
        XYChart.Series<Number, Number> series = new XYChart.Series();
        series.setName("My portfolio");
        //populating the series with data
        Random rand = new Random();

        Map<Integer, Integer> data = new TreeMap();
        //Create Chart data
        for (int i = 0; i < 3; i++) {
            data.put(rand.nextInt(51), rand.nextInt(51));
        }
        Set set = data.entrySet();

        //When you create the data points for the series, go ahead and add any assoicated data to the data point.
        int counter = 1;
        Iterator i = set.iterator();
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            System.out.println(me.getKey() + " - " + me.getValue());
            XYChart.Data tempData = new XYChart.Data(me.getKey(), me.getValue());
            tempData.setExtraValue("I am data point " + counter++);
            series.getData().add(tempData);//Add data to series
        }



        lineChart.getData().add(series);

        //loop through data and add tooltip
        //THIS MUST BE DONE AFTER ADDING THE DATA TO THE CHART!
        for (Data<Number, Number> entry : series.getData()) {
            System.out.println("Entered!");
            Tooltip t = new Tooltip(entry.getExtraValue().toString());
            Tooltip.install(entry.getNode(), t);
        }



        Scene scene = new Scene(lineChart, 800, 600);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }

}