import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.GroupedStackedBarRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.KeyToGroupMap;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.chart.ui.RectangleEdge;

/**
 * @see https://stackoverflow.com/a/17342522/230513
 */
public class DomainTranslateDemo extends ApplicationFrame {

    private static class DemoPanel extends JPanel implements ChangeListener {

        private static final int SLIDER_INITIAL_VALUE = -42;
        private static final double INCREMENT = 1 / 10.0;
        private final JSlider slider;
        private GroupedStackedBarRenderer renderer;

        public DemoPanel() {
            super(new BorderLayout());
            final CategoryDataset dataset = createDataset();
            final JFreeChart chart = createChart(dataset);
            final ChartPanel chartPanel = new ChartPanel(chart) {

                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(640, 360);
                }
            };
            add(chartPanel);

            JPanel dashboard = new JPanel(new BorderLayout());
            dashboard.setBorder(BorderFactory.createEmptyBorder(0, 4, 4, 4));

            this.slider = new JSlider(-50, 10, SLIDER_INITIAL_VALUE);
            this.slider.addChangeListener(this);
            dashboard.add(this.slider);
            add(dashboard, BorderLayout.SOUTH);
        }

        private CategoryDataset createDataset() {
            DefaultCategoryDataset result = new DefaultCategoryDataset();
            result.addValue(1.5, "5YEUR", "5Y");
            result.addValue(-1.5, "5YUSD", "5Y");
            result.addValue(0.5, "5Yx5YEUR", "5Yx5Y");
            result.addValue(-0.5, "5Yx5YUSD", "5Yx5Y");
            result.addValue(1.5, "10Yx5YEUR", "10Yx5Y");
            result.addValue(-1.5, "10Yx5YUSD", "10Yx5Y");
            result.addValue(1.5, "15Yx5YEUR", "15Yx5Y");
            result.addValue(-1.5, "15Yx5YUSD", "15Yx5Y");
            result.addValue(1.5, "20Yx5YEUR", "20Yx5Y");
            result.addValue(-1.5, "20Yx5YUSD", "20Yx5Y");
            result.addValue(1.5, "20Yx5YEUR", "25Yx5Y");
            result.addValue(-1.5, "20Yx5YUSD", "25Yx5Y");
            return result;
        }

        private JFreeChart createChart(final CategoryDataset dataset) {

            final JFreeChart chart = ChartFactory.createStackedBarChart(
                "Max Bar Width", // chart title
                "Category", // domain axis label
                "Value", // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, // the plot orientation
                true, // legend
                true, // tooltips
                false // urls
            );

            LegendTitle legend = chart.getLegend();
            legend.setPosition(RectangleEdge.TOP);
            legend.setFrame(BlockBorder.NONE);
            Font labelFont = legend.getItemFont().deriveFont(20f);
            legend.setItemFont(labelFont);

            renderer = new GroupedStackedBarRenderer();
            KeyToGroupMap map = new KeyToGroupMap("G1");
            map.mapKeyToGroup("5YEUR", "G1");
            map.mapKeyToGroup("5YUSD", "G1");
            map.mapKeyToGroup("5Yx5YEUR", "G2");
            map.mapKeyToGroup("5Yx5YUSD", "G2");
            map.mapKeyToGroup("10Yx5YEUR", "G3");
            map.mapKeyToGroup("10Yx5YUSD", "G3");
            map.mapKeyToGroup("15Yx5YEUR", "G4");
            map.mapKeyToGroup("15Yx5YUSD", "G4");
            map.mapKeyToGroup("20Yx5YEUR", "G5");
            map.mapKeyToGroup("20Yx5YUSD", "G5");
            map.mapKeyToGroup("25Yx5YEUR", "G6");
            map.mapKeyToGroup("25Yx5YUSD", "G6");
            renderer.setSeriesToGroupMap(map);
            renderer.setItemMargin(SLIDER_INITIAL_VALUE * INCREMENT);

            CategoryPlot plot = (CategoryPlot) chart.getPlot();
            plot.setRenderer(renderer);
            return chart;
        }

        @Override
        public void stateChanged(ChangeEvent event) {
            int value = slider.getValue();
            renderer.setItemMargin(value * INCREMENT);
        }
    }

    public DomainTranslateDemo(String title) {
        super(title);
        setContentPane(new DemoPanel());
    }

    public static JPanel createDemoPanel() {
        return new DemoPanel();
    }

    public static void main(String[] args) {
        DomainTranslateDemo demo = new DomainTranslateDemo("Translate Demo");
        demo.pack();
        demo.setLocationRelativeTo(null);
        demo.setVisible(true);
    }
}