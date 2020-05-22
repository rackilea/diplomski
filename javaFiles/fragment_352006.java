import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.Arrays;
import javax.swing.JFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.renderer.category.BoxAndWhiskerRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.statistics.DefaultBoxAndWhiskerCategoryDataset;

/**
 * @see https://stackoverflow.com/a/38242696/230513
 */
public class Test {

    private void display() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DefaultBoxAndWhiskerCategoryDataset boxData = new DefaultBoxAndWhiskerCategoryDataset();
        boxData.add(Arrays.asList(30, 36, 46, 55, 65, 76, 81, 80, 71, 59, 44, 34), "Planet", "Endor");
        boxData.add(Arrays.asList(22, 25, 34, 44, 54, 63, 69, 67, 59, 48, 38, 28), "Planet", "Hoth");
        BoxAndWhiskerRenderer boxRenderer = new BoxAndWhiskerRenderer();
        DefaultCategoryDataset catData = new DefaultCategoryDataset();
        catData.addValue(boxData.getMeanValue(0, 0), "Mean", boxData.getColumnKey(0));
        catData.addValue(boxData.getMeanValue(0, 1), "Mean", boxData.getColumnKey(1));
        LineAndShapeRenderer lineRenderer = new LineAndShapeRenderer();
        CategoryAxis xAxis = new CategoryAxis("Type");
        NumberAxis yAxis = new NumberAxis("Value");
        yAxis.setAutoRangeIncludesZero(false);
        CategoryPlot plot = new CategoryPlot(boxData, xAxis, yAxis, boxRenderer);
        plot.setDataset(1, catData);
        plot.setRenderer(1, lineRenderer);
        plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
        JFreeChart chart = new JFreeChart("Test", JFreeChart.DEFAULT_TITLE_FONT, plot, true);
        f.add(new ChartPanel(chart){
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(320, 480);
            }
        });
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Test()::display);
    }
}