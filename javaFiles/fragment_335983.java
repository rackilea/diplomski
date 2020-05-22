final XYSeries series1 = new XYSeries("Data 1", false, true);
    series1.add( 1.0 , 4.0 );
    series1.add( 2.0 , 5.0 );

    final XYSeries series2 = new XYSeries("Data 2", false, true);
    series2.add( 1.0 , 4.0 );
    series2.add( 2.5 , 7.0 );

    final XYSeriesCollection data = new XYSeriesCollection();
    data.addSeries(series1);
    data.addSeries(series2);

    final JFreeChart chart = ChartFactory.createXYLineChart(
            "XY Chart",
            "X",
            "Y",
            data,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
    );