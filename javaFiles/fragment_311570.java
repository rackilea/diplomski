// setup stroke
drawPaint = new Paint();
drawPaint.setColor(paintColor);
drawPaint.setAntiAlias(true);
drawPaint.setStrokeWidth(20);
drawPaint.setStyle(Paint.Style.STROKE);
drawPaint.setStrokeJoin(Paint.Join.ROUND);
drawPaint.setStrokeCap(Paint.Cap.ROUND);

// setup fill
fillPaint = new Paint();
fillPaint.setColor(fillColor);
fillPaint.setAntiAlias(true);
fillPaint.setStyle(Paint.Style.FILL);