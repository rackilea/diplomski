DefaultCategoryDataset dataset = new DefaultCategoryDataset();
for (Revenue revenue : revenueList) {
  // the middle parameter is for naming the value, can be empty if you have just one
  dataset.addValue(revenue.getRevenue(), "", revenue.getId());
}

JFreeChart chart = ChartFactory.createBarChart(
  "",
  "",
  "Revenues",
  dataset,
  PlotOrientation.VERTICAL,
  true,
  false,
  false
);                // or whatever parameters you need