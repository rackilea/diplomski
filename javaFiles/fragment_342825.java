ArrayList<String> xVals = new ArrayList<>();
//add labels to xVals
....
....

LineData lineData = new LineData(xVals, dataSets);

lineChart.setMarkerView(new MymarkerView(context, R.layout.custom_marker_view_layout, xVals);
lineChart.setData(lineData);