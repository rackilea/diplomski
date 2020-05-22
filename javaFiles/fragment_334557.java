Paint paint = new Paint();
paint.setStyle(Paint.Style.STROKE);
paint.setStrokeWidth(10);
paint.setPathEffect(new DashPathEffect(new float[]{8, 5}, 0));

LineGraphSeries<DataPoint> series = ... // init

series.setDrawAsPath(true);
series.setCustomPaint(paint);

graphView.addSeries(series);