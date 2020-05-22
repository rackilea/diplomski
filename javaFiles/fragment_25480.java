@Override
protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    for(MyRectangle rectangle : rectangleList){
        paint.setColor(rectangle.getColour());
        paint.setStrokeWidth(rectangle.getStroke());
        canvas.drawRect(rectangle.getPositionX(), rectangle.getPositionY(), rectangle.getWidth() / 2, rectangle.getHeight() / 2, paint);
    }
}