import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

/** @see https://stackoverflow.com/a/33898324/230513 */
public class Draw extends ApplicationFrame {

    private static final int INDEX = 5;
    private final XYSeries series = new XYSeries("Balance");
    private double balance;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new Draw("Test");
        });
    }

    public Draw(final String title) {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset())) {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(640, 360);
            }
        };
        add(chartPanel);
        add(new JButton(new AbstractAction("Update") {

            @Override
            public void actionPerformed(ActionEvent e) {
                balance += 5;
                series.addOrUpdate(INDEX, balance);
            }
        }), BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private XYDataset createDataset() {
        for (int i = 0; i < 11; i++) {
            series.add(i, 100.00);
        }
        series.remove(INDEX);
        series.add(INDEX, balance);
        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        return dataset;
    }

    private JFreeChart createChart(final XYDataset dataset) {
        final JFreeChart chart = ChartFactory.createXYLineChart(
            "Account Balance", // chart title
            "Month", // x axis label
            "Balance", // y axis label
            dataset, // data
            PlotOrientation.VERTICAL,
            false, // include legend
            true, // tooltips
            false // urls
        );
        return chart;
    }
}