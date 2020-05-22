package namepackage;

import com.panayotis.gnuplot.JavaPlot;
import com.panayotis.gnuplot.plot.DataSetPlot;
import com.panayotis.gnuplot.style.PlotStyle;
import com.panayotis.gnuplot.style.Style;

/**
 * on NetBeans add library -> jar -> 
 * package namepackage;
 *
 * import com.panayotis.gnuplot.JavaPlot;
 * import com.panayotis.gnuplot.plot.DataSetPlot;
 * import com.panayotis.gnuplot.style.PlotStyle;
 * import com.panayotis.gnuplot.style.Style;
 * @author mkwest
 *
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JavaPlot p = new JavaPlot();
        double tab[][];

        tab = new double[2][2];
        tab[0][0] = 0.0000;
        tab[0][1] = 2.0000;
        tab[1][0] = 1.0000;
        tab[1][1] = 6.0000;
        PlotStyle myPlotStyle = new PlotStyle();
        myPlotStyle.setStyle(Style.LINES);
        DataSetPlot s = new DataSetPlot(tab);
        myPlotStyle.setLineWidth(1);
        DataSetPlot testDataSetPlot = new DataSetPlot(tab);
        //DataSetPlot.setPlotStyle(myPlotStyle);
        s.setPlotStyle(myPlotStyle);
        //p.newGraph();
        p.addPlot(s);
        p.newGraph();
        p.plot();
    }
}