public class MyChartApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {

        // other app code...

        MyChart myChart = new MyChart();
        ChartData chartData = myChart.generateChartData();
        WritableImage image = myChart.constructChartImage(chartData);
        myChart.save(image, "chart.png");

        // other app code...
    }

    public static class MyChart {

        public WritableImage constructChartImage(ChartData data) {
            //defining the axes
            final NumberAxis xAxis = new NumberAxis();
            final NumberAxis yAxis = new NumberAxis();

            //creating the chart
            final LineChart<Number,Number> lineChart = 
                    new LineChart<>(xAxis,yAxis);

            lineChart.setAnimated(false);
            lineChart.setTitle(chartData.getChartTitle());

            //defining a series
            XYChart.Series series = new XYChart.Series();

            //populating the series with data
            addAll(series, chartData);

            Scene scene  = new Scene(lineChart,800,600);
            lineChart.getData().add(series);


            lineChart.applyCss();
            lineChart.layout();

            WritableImage image = scene.snapshot(null);

            return image ;
        }

        private ChartData generateChartData() {
            ChartData chartData = new ChartData();
            chartData.setValuesX(new double[]{1,2,3,4,5,6,7,8,9});
            chartData.setValuesY(new double[]{9,8,7,6,5,4,3,2,1});
            chartData.setChartTitle("My Chart");
            return chartData;
        }

        public void save(WritableImage image, String path) throws IOException {
            BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
            ImageIO.write(bImage, "png", new File(path));
        }

        private void addAll(XYChart.Series series, ChartData chartData) {
            double[] valuesX = chartData.getValuesX();
            double[] valuesY = chartData.getValuesX();
            for (int i = 0; i < valuesX.length; i++) {
                add(series, valuesX[i], valuesY[i]);
            }
        }

        private void add(XYChart.Series series, double x, double y) {
            series.getData().add(new XYChart.Data(x,y));
        }

    }

    public static class ChartData {
        private double[] valuesX;
        private double[] valuesY;
        private String chartTitle;

        public String getChartTitle() {
            return chartTitle;
        }

        public void setChartTitle(String chartTitle) {
            this.chartTitle = chartTitle;
        }

        public double[] getValuesX() {
            return valuesX;
        }

        public void setValuesX(double[] valuesX) {
            this.valuesX = valuesX;
        }

        public double[] getValuesY() {
            return valuesY;
        }

        public void setValuesY(double[] valuesY) {
            this.valuesY = valuesY;
        }
    }

}