// instantiate chart
NumberAxis xAxis = new NumberAxis(0, 10, 1);
NumberAxis yAxis = new NumberAxis(-100, 500, 100);        
ScatterXChart<Number,Number> sc = new ScatterXChart<>(xAxis,yAxis);
// .. fill with some data
...
// ui to add/change/remove a value marker
Data<Number, Number> horizontalMarker = new Data<>(0, 110);
Button add = new Button("Add Marker");  
add.setOnAction(e -> sc.addHorizontalValueMarker(horizontalMarker));
Slider move = new Slider(yAxis.getLowerBound(), yAxis.getUpperBound(), 0);
move.setShowTickLabels(true);
move.valueProperty().bindBidirectional(horizontalMarker.YValueProperty());
Button remove = new Button("Remove Marker");
remove.setOnAction(e -> sc.removeHorizontalValueMarker(horizontalMarker));