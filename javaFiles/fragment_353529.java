...
  chart.plot(data, bottomAxis, leftAxis);

  //set properties of first scatter chart data series to not smooth the line:
  ((XSSFChart)chart).getCTChart().getPlotArea().getScatterChartArray(0).getSerArray(0)
   .addNewSmooth().setVal(false);

  //set properties of first scatter chart to not vary the colors:
  ((XSSFChart)chart).getCTChart().getPlotArea().getScatterChartArray(0)
   .addNewVaryColors().setVal(false);
...