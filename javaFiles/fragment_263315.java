import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * @see https://stackoverflow.com/a/37216788/230513
 */
public class Test {

    private void display() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(24, "Major", "Mathematics");
        dataset.setValue(20, "Major", "Philosophy");
        dataset.setValue(18, "Major", "Chemical Engineering");
        dataset.setValue(15, "Major", "Sociology");
        dataset.setValue(14, "Major", "Stuff");
        dataset.setValue(13, "Major", "A Program");
        dataset.setValue(13, "Major", "Bleg");
        JFreeChart chart = ChartFactory.createBarChart("Title", "Major", "Score",
            dataset, PlotOrientation.HORIZONTAL, false, true, false);
        CategoryPlot plot = chart.getCategoryPlot();
        Font font1 = new Font("Dialog", Font.PLAIN, 25);
        Font font2 = new Font("Dialog", Font.PLAIN, 15);
        Font font3 = new Font("Dialog", Font.PLAIN, 25);
        plot.getDomainAxis().setLabelFont(font3);
        plot.getRangeAxis().setLabelFont(font3);
        CategoryAxis axisDomain = plot.getDomainAxis();
        axisDomain.setTickLabelFont(font1);
        ValueAxis axisRange = plot.getRangeAxis();
        axisRange.setTickLabelFont(font2);
        chart.setAntiAlias(true);
        f.add(new ChartPanel(chart){
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(1024, 512);
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