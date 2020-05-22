public LineChartWithMarker(@NamedArg("xAxis") Axis<X> xAxis, 
        @NamedArg("yAxis") Axis<Y> yAxis) 
{
    super(xAxis, yAxis);

    horizontalMarkers = FXCollections.observableArrayList(data -> new Observable[] {data.YValueProperty()});
    horizontalMarkers.addListener((InvalidationListener)observable -> layoutPlotChildren());
}