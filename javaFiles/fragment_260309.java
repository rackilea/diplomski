for (Map.Entry<String, List<Coordinates>> serie : newList.entrySet()) {
    List<Double> xData = new ArrayList<>();
    List<Double> yData = new ArrayList<>();

    for (Coordinates coord : serie.getValue()) {
        xData.add(coord.getX());
        yData.add(coord.getY());
    }

    chart.addSeries(serie.getKey(), xData, yData);
}