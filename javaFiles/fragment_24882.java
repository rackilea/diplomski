FileInputStream inputStream;

inputStream = openFileInput(fileListName);
ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

ArrayList <MyEntry> myEntries = (ArrayList<MyEntry>) objectInputStream.readObject();
ArrayList<Entry> entries = new ArrayList<>();
for (int i = 0; i < myEntries.size(); i++) {
  MyEntry currentMyEntry = myEntries.get(i);
  Entry currentEntry = new Entry();
  currentEntry.setX(currentMyEntry.getX());
  currentEntry.setY(currentMyEntry.getY());
  entries.add(currentEntry);
}

// Set chart properties
chart = ChartUtils.setChartProperties(chart);

LineDataSet lineDataSet = ChartUtils.createSet(ChartViewer.this, entries);

LineData data = new LineData(lineDataSet);
chart.setData(data);