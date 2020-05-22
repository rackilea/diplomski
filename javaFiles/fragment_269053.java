String Male1 = "First";
String Male2 = "sec";
String Female1 = "Category 1";
String Female2 = "Category 2";
DefaultCategoryDataset dataset = new DefaultCategoryDataset();
dataset.addValue(10, Male1, Female1);
dataset.addValue(12, Male1, Female2);
dataset.addValue(22, Male2, Female1);
dataset.addValue(50, Male2, Female2);
final JFreeChart chart = ChartFactory.createBarChart(
     "Bar Chart Demo", "Category", "Score", dataset,
     PlotOrientation.VERTICAL, true, true, false);
BarRenderer br = new BarRenderer();
br.setItemMargin(0.0);
chart.getCategoryPlot().setRenderer(br);
try {
    ChartUtilities.saveChartAsPNG(new File("E:\\jfreeBarchart.png"), chart, 500, 500);
    System.out.println("=====chart=====");
} catch (Exception e) {
    e.printStackTrace();
}