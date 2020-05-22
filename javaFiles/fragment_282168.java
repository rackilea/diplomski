for (XYChart.Series<String, Number> series : bc.getData()) {
    for (XYChart.Data<String, Number> item : series.getData()) {
        item.getNode().setOnMousePressed((MouseEvent event) -> {
            System.out.println("you clicked " + item.toString() + series.toString());
        });
        Tooltip.install(item.getNode(), new Tooltip(item.getXValue() + ":\n" + item.getYValue()));
    }
}