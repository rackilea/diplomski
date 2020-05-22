ObservableList<XYChart.Data> dataSet = EasyBind.map(sortedList, this::makeChartData) ;

// ...

private XYChart.Data makeChartData(PlanItem planItem) {
    // Just return a XYChart.Data corresponding to planItem
}