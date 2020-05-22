public class MyViewImpl implements MyView {
    private Panel main;
    private AsyncChart<LineChart> asyncLineChart;

    public MyViewImpl() {
        this.main = new FlowPanel();

        // Runnable wrapper (see next snippet.)
        this.asyncLineChart = new AsyncChart<LineChart>() {
            @Override
            public LineChart onAttach(DataTable data, Options options) {
                // Instantiate and attach new chart.
                LineChart lineChart = new LineChart(data, options);
                main.add(lineChart);

                return lineChart;
            }
        };

        // Load Google Visualization asynchronously.
        VisualizationUtils.loadVisualizationApi(this.asyncLineChart, LineChart.PACKAGE);
    }

    @Override
    public void render(final MyResult result) { // Invoked from Presenter (see above snippet.)
        // Schedule rendering to be invoked ASAP (but not before Visualization library is loaded.)
        this.asyncLineChart.enqueueWriter(new AsyncChartWriter() {
            @Override
            public void onWrite(DataTable data, Options options) {
                // Populate data from RPC result.
                data.addColumn(ColumnType.DATE);
                data.addRow();
                data.setValue(0, 0, result.getDate());
                // ... Etc.

                // Set options.
                options.setWidth(500);
                // ... Etc.
            }
        });
    }
}