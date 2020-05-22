public void initialize(){       
    initChartProperties();
    initInputControls();        
    XYChart.Series<Number, Number> series = getSeries();        
    chart.getData().add(series);
}