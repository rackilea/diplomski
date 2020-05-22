void draw(AppChart chart, ChartData data) {
    switch (data.getType()) {
        case PIE_CHART:
            AppPieChart<Numeric> pieChart = (AppPieChart<Numeric>) chart;
            // ...
            break;
        case TABLE_CHART:
            AppTableChart tableChart = (AppTableChart) chart;
            // ...
            break;
        // ...
    }
}