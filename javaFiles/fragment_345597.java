public class ScatterXChart<X, Y> extends ScatterChart<X, Y> {

    // data defining horizontal markers, xValues are ignored
    private ObservableList<Data<X, Y>> horizontalMarkers;

    public ScatterXChart(Axis<X> xAxis, Axis<Y> yAxis) {
        super(xAxis, yAxis);
        // a list that notifies on change of the yValue property
        horizontalMarkers = FXCollections.observableArrayList(d -> new Observable[] {d.YValueProperty()});
        // listen to list changes and re-plot
        horizontalMarkers.addListener((InvalidationListener)observable -> layoutPlotChildren());
    }

    /**
     * Add horizontal value marker. The marker's Y value is used to plot a
     * horizontal line across the plot area, its X value is ignored.
     * 
     * @param marker must not be null.
     */
    public void addHorizontalValueMarker(Data<X, Y> marker) {
        Objects.requireNonNull(marker, "the marker must not be null");
        if (horizontalMarkers.contains(marker)) return;
        Line line = new Line();
        marker.setNode(line );
        getPlotChildren().add(line);
        horizontalMarkers.add(marker);
    }

    /**
     * Remove horizontal value marker.
     * 
     * @param horizontalMarker must not be null
     */
    public void removeHorizontalValueMarker(Data<X, Y> marker) {
        Objects.requireNonNull(marker, "the marker must not be null");
        if (marker.getNode() != null) {
            getPlotChildren().remove(marker.getNode());
            marker.setNode(null);
        }
        horizontalMarkers.remove(marker);
    }

    /**
     * Overridden to layout the value markers.
     */
    @Override
    protected void layoutPlotChildren() {
        super.layoutPlotChildren();
        for (Data<X, Y> horizontalMarker : horizontalMarkers) {
            double lower = ((ValueAxis) getXAxis()).getLowerBound();
            X lowerX = getXAxis().toRealValue(lower);
            double upper = ((ValueAxis) getXAxis()).getUpperBound();
            X upperX = getXAxis().toRealValue(upper);
            Line line = (Line) horizontalMarker.getNode();
            line.setStartX(getXAxis().getDisplayPosition(lowerX));
            line.setEndX(getXAxis().getDisplayPosition(upperX));
            line.setStartY(getYAxis().getDisplayPosition(horizontalMarker.getYValue()));
            line.setEndY(line.getStartY());

        }
    }
}