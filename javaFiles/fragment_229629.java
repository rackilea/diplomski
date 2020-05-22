interface AppChart {
    void setupChart();
    void bindChart(ChartData data);
}

class AppPieChart<T> implements AppChart {
    private PieChart<T> chart;

    public AppPieChart(PieChart<T> chart) {
        this.chart = chart;
    }

    @Override
    public void setupChart() {
        //...
    }

    // ...
}

class AppTableChart implements AppChart {
    private TableChart chart;

    public AppTableChart(TableChart chart) {
        this.chart = chart;
    }

    @Override
    public void setupChart() {
        //...
    }

    // ...
}