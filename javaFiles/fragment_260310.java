newList.forEach((key, value) -> {
    List<Double> xData = new ArrayList<>();
    List<Double> yData = new ArrayList<>();

    value.forEach(c -> {
        xData.add(c.getX());
        yData.add(c.getY());
    });

    chart.addSeries(key, xData, yData);
});