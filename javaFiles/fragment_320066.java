//This gets rid of the gray grid
mySimpleXYPlot.getGraphWidget().getGridBackgroundPaint().setColor(Color.TRANSPARENT);

//This gets rid of the black border (up to the graph) there is no black border around the labels
mysimpleXYPlot.getBackgroundPaint().setColor(Color.TRANSPARENT);

//This gets rid of the black behind the graph
mySimpleXYPlot.getGraphWidget().getBackgroundPaint().setColor(Color.TRANSPARENT);

//With a new release of AndroidPlot you have to also set the border paint
plot.getBorderPaint().setColor(Color.TRANSPARENT);