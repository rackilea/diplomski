import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

public class ChartServlet extends HttpServlet {

    /*
     * (non-Javadoc) @see
     * javax.servlet.http.HttpServlet#doGet(
     * javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        JFreeChart chart = this.generateLineChart();
        ServletOutputStream out = resp.getOutputStream();
        resp.setContentType("image/png");
        ChartUtilities.writeChartAsPNG(out, chart, 640, 480);
        out.close();
    }

    /**
     * Generate chart.
     *
     * @return the j free chart
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private JFreeChart generateLineChart() throws IOException {

        return chart;
    }

    /*
     * (non-Javadoc) @see javax.servlet.GenericServlet#init()
     */
    @Override
    public void init() throws ServletException {
        // TODO Auto-generated method stub
        System.out.println("Starting up charts servlet.");
    }
}