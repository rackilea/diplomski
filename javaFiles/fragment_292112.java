import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickMarkPosition;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.DateTickUnitType;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.IntervalXYDataset;

/**
 * @see https://stackoverflow.com/a/54362133/230513
 * @see https://stackoverflow.com/a/42612723/230513
 */
public class Test {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Test()::display);
    }

    private void display() {
        JFrame f = new JFrame("Data");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(0, 1));
        IntervalXYDataset dataset = createDataset();
        f.add(createPanel(ChartFactory.createXYBarChart("Data", "Time", true, "Value", dataset)));
        f.add(createPanel(ChartFactory.createTimeSeriesChart("Data", "Time", "Value", dataset)));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private ChartPanel createPanel(JFreeChart chart) {
        final XYPlot plot = chart.getXYPlot();
        final DateAxis domainAxis = (DateAxis) plot.getDomainAxis();
        domainAxis.setTickUnit(new DateTickUnit(DateTickUnitType.YEAR, 1));
        domainAxis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
        domainAxis.setDateFormatOverride(new SimpleDateFormat("yyyy"));
        return new ChartPanel(chart) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(500, 250);
            }
        };
    }

    private IntervalXYDataset createDataset() {
        TimeSeries series = new TimeSeries("Value");
        Calendar c = Calendar.getInstance();
        for (int i = 0; i < 7; i++) {
            series.add(new Year(c.getTime()), i + 1);
            c.add(Calendar.YEAR, 1);
        }
        return new TimeSeriesCollection(series);
    }
}