XYSeriesCollection data = new XYSeriesCollection();
XYSeries series = new XYSeries("Test");
data.addSeries(series);
series.add(1, 42);
System.out.println(data.getSeries(0).getY(0));
XYSeriesCollection dataCopy = (XYSeriesCollection) data.clone();
series.updateByIndex(0, 21.0);
System.out.println(data.getSeries(0).getY(0));
System.out.println(dataCopy.getSeries(0).getY(0));