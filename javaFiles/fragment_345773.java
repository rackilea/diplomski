private static JFreeChart createChart() {
   CombinedDomainXYPlot localCombinedDomainXYPlot = new CombinedDomainXYPlot(new DateAxis("Time"));

   JFreeChart localJFreeChart = new JFreeChart("Sample", localCombinedDomainXYPlot);
   localCombinedDomainXYPlot.add(createSubplot1(createDataset1()), 1);
   ChartUtilities.applyCurrentTheme(localJFreeChart);
   localJFreeChart.setBackgroundPaint(Color.white);

   final LegendItemCollection legendItemsOld = localCombinedDomainXYPlot.getLegendItems();
   LegendItemSource source = new LegendItemSource() {
      public LegendItemCollection getLegendItems() {
         LegendItemCollection lic = new LegendItemCollection();
         int itemCount = legendItemsOld.getItemCount();
         for (int i = 0; i < itemCount; i++) {
            lic.add(legendItemsOld.get(i));
         }
         return lic;
      }
   };
   localJFreeChart.removeLegend();
   localJFreeChart.addLegend(new LegendTitle(source));
   localJFreeChart.getLegend().setPosition(RectangleEdge.TOP);
   localJFreeChart.getLegend().getItemContainer().getBlocks();

   return localJFreeChart;
}