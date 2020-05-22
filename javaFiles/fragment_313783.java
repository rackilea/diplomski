private void initDrawingTools() {
        textPaint = new Paint();
        textPaint.setColor(0xFF000000);
        textPaint.setTextSize(30);
        textPaint.setTypeface(Typeface.SERIF);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setAntiAlias(true);

        textOutlinePaint = new Paint();
        textOutlinePaint.setColor(0xFF000000);
        textOutlinePaint.setTextSize(18);
        textOutlinePaint.setTypeface(Typeface.SERIF);
        textOutlinePaint.setTextAlign(Paint.Align.CENTER);
        textOutlinePaint.setStyle(Paint.Style.STROKE);
        textOutlinePaint.setStrokeWidth(2);

        bubblePaint = new Paint();
        bubblePaint.setColor(Color.GREEN);
        bubbleShadowPaint = new Paint();
        bubbleShadowPaint.setColor(0xFF000000);
        bookedBubblePaint= new Paint();
        bookedBubblePaint.setColor(Color.RED);
    }

    public void addBubble(String text, int areaId) {
        if (mBubbleMap.get(areaId) == null) {
            Bubble b = new Bubble(text, areaId);
            mBubbleMap.put(areaId, b);
        }
    }

    public void addBookedBubble(String text, int areaId) {
        if (bookedBubble.get(areaId) == null) {
            Bubble b = new Bubble(text, areaId);
            bookedBubble.put(areaId, b);
        }
    }