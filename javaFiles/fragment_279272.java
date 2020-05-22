public ScheduleListView(Context context, AttributeSet attrs) {
    super(context, attrs);
    paint.setColor(Color.GRAY);
    paint.setAlpha(100);
    paint.setColor(Color.parseColor("#47B3EA"));

}

@Override
protected void onDraw(Canvas canvas) {
    canvas.drawRect(this.getLeft(), 10, this.getRight(), 10, paint);
    super.onDraw(canvas);
    canvas.restore();
}