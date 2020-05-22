private Bitmap savedBitmap;
public YourView(Context context) {
    super(context);
}
public void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    System.out.println(canvas.getWidth()+" "+canvas.getHeight());

    Paint textPaint = new Paint();
    textPaint.setARGB(255, 0, 0, 0);
    textPaint.setTextAlign(Paint.Align.RIGHT);
    textPaint.setTextSize(11);
    textPaint.setTypeface(Typeface.DEFAULT);

    canvas.drawColor(Color.WHITE);
    System.out.println(canvas.getWidth());
    System.out.println(canvas.getHeight());

    canvas.drawRect(200, 20, 500, 100, textPaint);
}