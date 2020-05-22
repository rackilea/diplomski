XYPlot plot = chart.getXYPlot();
  plot.setDataset(0, xyDataset1);
  plot.setDataset(1, xyDataset2);
  XYLineAndShapeRenderer renderer0 = new XYLineAndShapeRenderer(); 
  XYLineAndShapeRenderer renderer1 = new XYLineAndShapeRenderer(); 
  plot.setRenderer(0, renderer0); 
  plot.setRenderer(1, renderer1); 
  plot.getRendererForDataset(plot.getDataset(0)).setSeriesPaint(0, Color.red); 
  plot.getRendererForDataset(plot.getDataset(1)).setSeriesPaint(0, Color.blue);