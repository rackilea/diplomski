final CategoryAxis yAxis = new CategoryAxis();
final NumberAxis zAxis = new NumberAxis(); 

XYChart<String, Number> chart = null ;

if (cbTypeGraphView.equals("Bar Chart")) {
    chart = new BarChart<String, Number>(yAxis,xAxis);
}
if (cbTypeGraphView.equals("Line Chart")) {
    chart = new LineChart<String, Number>(yAxis,xAxis);
}

AnchorPane.setTopAnchor(chart, 110d);
AnchorPane.setLeftAnchor(chart, 10d);
AnchorPane.setRightAnchor(chart, 5d);
AnchorPane.setBottomAnchor(chart, 50d);