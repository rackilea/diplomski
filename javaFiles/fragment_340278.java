import java.io.ByteArrayOutputStream
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartUtilities;

JFreeChart myChart = ...
ByteArrayOutputStream out = new ByteArrayOutputStream();
ChartUtilities.writeChartAsPNG(out, myChart, width, height);