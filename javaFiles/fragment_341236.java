JFreeChart chart = functionWhichRetrievesTheChart();
ChartRenderingInfo info = new ChartRenderingInfo();
// PLOT_SIZE is the size if the graph and has to be the same size as the original drawn chart.createBufferedImage(PLOT_SIZE, PLOT_SIZE, info); 
graph, otherwise the pixel position points to somewhere else
PlotRenderingInfo plotInfo = info.getPlotInfo();


XYPlot plot = (XYPlot)chart.getPlot();
Point p = new Point(x,y); // x and y are the pixel positions

// this is the domain value which belongs to the pixel position x
double domain = plot.getDomainAxis().java2DToValue(p.getX(), plotInfo.getDataArea(), plot.getDomainAxisEdge()); 

// this is the range value which belongs to the pixel position y
double range = plot.getRangeAxis().java2DToValue(p.getY(), plotInfo.getDataArea(), plot.getRangeAxisEdge());