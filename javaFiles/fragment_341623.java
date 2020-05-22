if ( itemIndex > 0 && itemIndex < series.getDataSize() ) {
    animate = true;
    XYChart.Data<X, Y> p1 = series.getItem( itemIndex - 1 );
    XYChart.Data<X, Y> p2 = series.getItem( itemIndex + 1 );
    ...
    ...
}