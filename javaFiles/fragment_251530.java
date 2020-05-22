public class MyView extends View {

    Bitmap bitmap;

    public MyView(Context context) {
        bitmap = Bitmap.createBitmap(1920, 1080, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(10);

        float left = 20;
        float top = 20;
        float right = 50;
        float bottom = 100;

        canvas.drawLine(left, top, right, bottom, paint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(bitmap, 0, 0, null);
        super.onDraw(canvas);
    }
}