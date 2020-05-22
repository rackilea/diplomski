private ObservableList<Data<X, X>> verticalRangeMarkers;

public LineChartWithMarkers(Axis<X> xAxis, Axis<Y> yAxis) {
    ...            
    verticalRangeMarkers = FXCollections.observableArrayList(data -> new Observable[] {data.XValueProperty()});
    verticalRangeMarkers = FXCollections.observableArrayList(data -> new Observable[] {data.YValueProperty()}); // 2nd type of the range is X type as well
    verticalRangeMarkers.addListener((InvalidationListener)observable -> layoutPlotChildren());
}        


public void addVerticalRangeMarker(Data<X, X> marker) {
    Objects.requireNonNull(marker, "the marker must not be null");
    if (verticalRangeMarkers.contains(marker)) return;

    Rectangle rectangle = new Rectangle(0,0,0,0);
    rectangle.setStroke(Color.TRANSPARENT);
    rectangle.setFill(Color.BLUE.deriveColor(1, 1, 1, 0.2));

    marker.setNode( rectangle);

    getPlotChildren().add(rectangle);
    verticalRangeMarkers.add(marker);
}

public void removeVerticalRangeMarker(Data<X, X> marker) {
    Objects.requireNonNull(marker, "the marker must not be null");
    if (marker.getNode() != null) {
        getPlotChildren().remove(marker.getNode());
        marker.setNode(null);
    }
    verticalRangeMarkers.remove(marker);
}

protected void layoutPlotChildren() {

    ...

    for (Data<X, X> verticalRangeMarker : verticalRangeMarkers) {

        Rectangle rectangle = (Rectangle) verticalRangeMarker.getNode();
        rectangle.setX( getXAxis().getDisplayPosition(verticalRangeMarker.getXValue()) + 0.5);  // 0.5 for crispness
        rectangle.setWidth( getXAxis().getDisplayPosition(verticalRangeMarker.getYValue()) - getXAxis().getDisplayPosition(verticalRangeMarker.getXValue()));
        rectangle.setY(0d);
        rectangle.setHeight(getBoundsInLocal().getHeight());
        rectangle.toBack();

    }
}