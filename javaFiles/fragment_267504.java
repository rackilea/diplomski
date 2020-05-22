ArrayList<DataPoint> points = new ArrayList<>();
points.add(new DataPoint(0, 1));
points.add(new DataPoint(1, 5));
points.add(new DataPoint(2, 3));
points.add(new DataPoint(3, 2));
points.add(new DataPoint(4, 6));
DataPoint[] dbPoint = points.toArray(new DataPoint[points.size()]);

LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dbPoint);