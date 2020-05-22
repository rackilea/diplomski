private class CircleView extends View{
    Paint paint = new Paint();

    public CircleView(Context context) {
        super(context);
    }

    @Override
    public void onDraw(Canvas canvas) {
        paint.setColor(Color.GREEN);
        // set your own position and radius
        canvas.drawCircle(100,200,100,paint);
    }
}