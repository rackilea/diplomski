import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import javax.imageio.ImageIO;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;
import org.jfree.ui.*;

@SuppressWarnings("serial")
public class CategoryLabelWithShape extends ApplicationFrame {

    public CategoryLabelWithShape(final String title) {
        super(title);
        final JFreeChart chart = constructChart();
        final ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    JFreeChart constructChart() {
        JFreeChart chart = ChartFactory.createBarChart(
            "MEP seats","country","# seats",getDataSet(),PlotOrientation.VERTICAL,true,true,false
        );

        CategoryPlot cp = chart.getCategoryPlot();

        CategoryAxis daNew = new CategoryAxis(){
            protected AxisState drawCategoryLabels(Graphics2D g2,
                    Rectangle2D plotArea,
                    Rectangle2D dataArea,
                    RectangleEdge edge,
                    AxisState state,
                    PlotRenderingInfo plotState) {

                if (isTickLabelsVisible()) {
                    List<CategoryTick> ticks = (List<CategoryTick>)refreshTicks(g2, state, plotArea, edge);

                    int categoryIndex = 0;
                    for (CategoryTick tick : ticks) {
                        double x0 = getCategoryStart(categoryIndex, ticks.size(), dataArea, edge);
                        double y0 = state.getCursor() + getCategoryLabelPositionOffset();


                        CountryFlag cf = (CountryFlag)((CategoryPlot)getPlot()).getDataset().getColumnKey(categoryIndex);
                        try {
                            BufferedImage img = ImageIO.read(new URL(cf.flagUrl));

                            g2.drawImage(img, (int)(x0-img.getWidth()), (int)(y0), img.getWidth(), img.getHeight(), Color.black, null);
                        } catch (IOException e) {
                            // skip flag
                        }

                        categoryIndex++;
                    }
                }               
                return super.drawCategoryLabels(g2, plotArea, dataArea, edge, state, plotState);
            }
        };

        daNew.setLabel(cp.getDomainAxis().getLabel());
        cp.setDomainAxis(daNew);

        return chart;
    }

    static class CountryFlag implements Comparable<CountryFlag> {
        String name, flagUrl;
        CountryFlag(String name, String flagUrl) {
            this.name = name;
            this.flagUrl = flagUrl;
        }
        public int compareTo(CountryFlag o) {
            return name.compareTo(o.name);
        }
        public String toString() {
            return name;
        }
    }

    private CategoryDataset getDataSet() {
        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        ds.addValue(99, "MEP seats", new CountryFlag("Germany","http://upload.wikimedia.org/wikipedia/en/thumb/b/ba/Flag_of_Germany.svg/22px-Flag_of_Germany.svg.png"));
        ds.addValue(72, "MEP seats", new CountryFlag("France","http://upload.wikimedia.org/wikipedia/en/thumb/c/c3/Flag_of_France.svg/22px-Flag_of_France.svg.png"));
        ds.addValue(72, "MEP seats", new CountryFlag("Italy","http://upload.wikimedia.org/wikipedia/en/thumb/0/03/Flag_of_Italy.svg/22px-Flag_of_Italy.svg.png"));
        ds.addValue(72, "MEP seats", new CountryFlag("United Kingdom","http://upload.wikimedia.org/wikipedia/en/thumb/a/ae/Flag_of_the_United_Kingdom.svg/22px-Flag_of_the_United_Kingdom.svg.png"));
        ds.addValue(50, "MEP seats", new CountryFlag("Spain","http://upload.wikimedia.org/wikipedia/en/thumb/9/9a/Flag_of_Spain.svg/22px-Flag_of_Spain.svg.png"));
        ds.addValue(50, "MEP seats", new CountryFlag("Poland","http://upload.wikimedia.org/wikipedia/en/thumb/1/12/Flag_of_Poland.svg/22px-Flag_of_Poland.svg.png"));
        ds.addValue(33, "MEP seats", new CountryFlag("Romania","http://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Flag_of_Romania.svg/22px-Flag_of_Romania.svg.png"));
        ds.addValue(25, "MEP seats", new CountryFlag("Netherlands","http://upload.wikimedia.org/wikipedia/commons/thumb/2/20/Flag_of_the_Netherlands.svg/22px-Flag_of_the_Netherlands.svg.png"));
        ds.addValue(22, "MEP seats", new CountryFlag("Belgium","http://upload.wikimedia.org/wikipedia/commons/thumb/9/92/Flag_of_Belgium_%28civil%29.svg/22px-Flag_of_Belgium_%28civil%29.svg.png"));
        ds.addValue(22, "MEP seats", new CountryFlag("Czech Republic","http://upload.wikimedia.org/wikipedia/commons/thumb/c/cb/Flag_of_the_Czech_Republic.svg/22px-Flag_of_the_Czech_Republic.svg.png"));
        return ds;
    }


    public static void main(String[] args) {
        CategoryLabelWithShape demo = new CategoryLabelWithShape(
                "Category-label with a shape");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
}