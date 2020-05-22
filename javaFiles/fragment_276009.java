import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.FileOutputStream;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.DefaultFontMapper;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Approaching Pi, Inc. http://www.approachingpi.com
 * <p/>
 * User: tcurran Date: Mar 17, 2008 Time: 2:29:43 AM Desc:
 */
public class PdfChartDemo {

    public static void main(String[] args) throws DocumentException {

        try {
            Document doc = new Document(PageSize.A4);
            PdfWriter docWriter = PdfWriter.getInstance(doc,
                    new FileOutputStream("D:/helix-fossil.pdf"));
            doc.open();

            doc.addProducer();
            doc.addCreator("Jay Leno");
            doc.addTitle("jfreechart pdf");
            doc.setPageSize(PageSize.LETTER);

            doc.open();

            // add some text to the document
            doc.add(new Phrase(
                    "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod "
                            + "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, "
                            + "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
                            + "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu "
                            + "fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, "
                            + "sunt in culpa qui officia deserunt mollit anim id est laborum."));

            // build up the dataset for the chart
            XYSeriesCollection dataset = new XYSeriesCollection();

            XYSeries series = new XYSeries("XYGraph");
            series.add(1, 1);
            series.add(2, 3);
            series.add(3, 9);
            series.add(4, 11);

            dataset.addSeries(series);

            // set up the chart
            JFreeChart chart = ChartFactory.createXYLineChart(
                    "XY Chart Sample, non default font", // chart title
                    "x-axis", // domain axis label
                    "y-axis", // range axis label
                    dataset, // data
                    PlotOrientation.VERTICAL, // orientation
                    true, // include legend
                    true, // tooltips
                    false // urls
                    );

            // trick to change the default font of the chart
            chart.setTitle(new TextTitle("XY Chart Sample, non default font",
                    new java.awt.Font("Serif", Font.BOLD, 12)));
            chart.setBackgroundPaint(Color.white);
            chart.setBorderPaint(Color.black);
            chart.setBorderStroke(new BasicStroke(1));
            chart.setBorderVisible(true);

            int width = 260;
            int height = 250;

            // get the direct pdf content
            PdfContentByte dc = docWriter.getDirectContent();

            // get a pdf template from the direct content
            PdfTemplate tp = dc.createTemplate(width, height);

            // create an AWT renderer from the pdf template
            Graphics2D g2 = tp.createGraphics(width, height,
                    new DefaultFontMapper());
            Rectangle2D r2D = new Rectangle2D.Double(0, 0, width, height);
            chart.draw(g2, r2D, null);
            g2.dispose();

            // add the rendered pdf template to the direct content
            // you will have to play around with this because the chart is
            // absolutely positioned.
            // 38 is just a typical left margin
            // docWriter.getVerticalPosition(true) will approximate the position
            // that the content above the chart ended
            dc.addTemplate(tp, 38, docWriter.getVerticalPosition(true) - height);

            doc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}