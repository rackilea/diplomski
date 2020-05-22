import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

import javax.swing.*;
import java.awt.*;

public class IccGraph extends ApplicationFrame {

public IccGraph(String title){
    super(title);
    JPanel chartPanel = createPanel();
    chartPanel.setPreferredSize(new Dimension(450, 400));
    setContentPane(chartPanel);

}

private double probability(double x, double b){
    double top = Math.exp(x-b);
    double prob = top/(1+top);
    return prob;
}

public XYSeriesCollection createData(){
    XYSeriesCollection dataset = new XYSeriesCollection();
    XYSeries series1 = new XYSeries("Wide Points");
    XYSeries series2 = new XYSeries("Close Points");
    XYSeries series3 = new XYSeries("Very Close Points");

    double maxValue = 4.0;
    double value = -4.0;
    double prob = 0.0;

    //create series where x-axis values use increments of .5
    //will produce graph with dashes as expected
    while(value<maxValue){
        prob = probability(value, -1.0);
        series1.add(value, prob);
        value += .5;
    }

    //create series where x-axis values use increments of .1
    //will produce line with some dashes
    value = -4.0;
    while(value<maxValue){
        prob = probability(value, 0.0);
        series2.add(value, prob);
        value += .1;
    }

    //create series where x-axis values use increments of .01
    //will produce straight lines in graph
    value = -4.0;
    while(value<maxValue){
        prob = probability(value, 1.0);
        series3.add(value, prob);
        value += .01;
    }

    dataset.addSeries(series1);
    dataset.addSeries(series2);
    dataset.addSeries(series3);

    return dataset;
}

public JPanel createPanel(){
    JFreeChart chart = createChart(createData());
    ChartPanel panel = new ChartPanel(chart);
    return panel;
}

public JFreeChart createChart(XYSeriesCollection dataset){
    JFreeChart chart = ChartFactory.createXYLineChart(
                "",            // chart title
                "Theta",       // x axis label
                "Probability", // y axis label
                dataset,       // data
                PlotOrientation.VERTICAL,
                true,          // include legend
                true,          // tooltips
                false          // urls
        );

    XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(){
        @Override
        public Stroke getItemStroke(int row, int col){
            Stroke dash1 = new BasicStroke(1.0f,
                        BasicStroke.CAP_SQUARE,
                        BasicStroke.JOIN_MITER,
                        10.0f,
                        new float[] {10.0f,5.0f},
                        0.0f);
            return dash1;
        }
    };
    renderer.setBaseShapesFilled(false);
    renderer.setDrawOutlines(false);
    renderer.setDrawSeriesLineAsPath(true);//this line is the solution

    XYPlot plot = (XYPlot)chart.getPlot();
    plot.setRenderer(renderer);

    return chart;
}

public static void main(String[] args) {
    IccGraph graph = new IccGraph("Line Dash Problem");
    graph.pack();
    graph.setVisible(true);
}


}