import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.Timer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * @see https://stackoverflow.com/a/15715096/230513
 * @see https://stackoverflow.com/a/11949899/230513
 */
public class TabChart {

    private static final int N = 128;
    private static final Random random = new Random();
    private int n = 1;

    private void display() {
        JFrame f = new JFrame("TabChart");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JTabbedPane jtp = new JTabbedPane();
        jtp.add(String.valueOf(n), createPane());
        f.add(jtp, BorderLayout.CENTER);
        JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p.add(new JButton(new AbstractAction("Add") {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.add(String.valueOf(++n), createPane());
                jtp.setSelectedIndex(n - 1);
            }
        }));
        f.add(p, BorderLayout.SOUTH);
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
        new Timer(1000, new ActionListener() {

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
                new TabChart().display();
            }
        });
    }
}