@Override
    protected void onDraw(Canvas canvas) {
        float offset = getTextSize() - getLineHeight();
        canvas.translate(0, -offset); //or +offset to moving it to top
        super.onDraw(canvas);
    }