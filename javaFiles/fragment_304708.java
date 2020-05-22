populateCharts(chartA, chartB);
    chartA.getData().get(0).getData().forEach((item) -> {
        item.getNode().setStyle("-fx-background-color: red");
    });
    chartB.getData().get(0).getData().forEach((item) -> {
        item.getNode().setStyle("-fx-background-color: green");
    });