import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * @see http://stackoverflow.com/a/38512314/230513
 * @see http://stackoverflow.com/a/15715096/230513
 * @see http://stackoverflow.com/a/11949899/230513
 */
public class Test {

    private static final int N = 128;
    private static final Random random = new Random();
    private int n = 1;

    private void display() {
        JFrame f = new JFrame("TabChart");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p = new JPanel(new GridLayout(0, 1));
        for (int i = 0; i < 3; i++) {
            p.add(createPane());
        }
        f.add(p, BorderLayout.CENTER);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private ChartPanel createPane() {
        final XYSeries series = new XYSeries("Data");
        for (int i = 0; i < random.nextInt(N) + N / 2; i++) {
            series.add(i, random.nextGaussian());
        }
        XYSeriesCollection dataset = new XYSeriesCollection(series);
        new Timer(500, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                series.add(series.getItemCount(), random.nextGaussian());
            }
        }).start();
        JFreeChart chart = ChartFactory.createXYLineChart("Test", "Domain",
            "Range", dataset, PlotOrientation.VERTICAL, false, false, false);
        return new ChartPanel(chart) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(480, 240);
            }
        };
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test().display();
            }
        });
    }
}