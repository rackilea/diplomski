public class DrawV extends View {

private Bitmap bit_dot;

public DrawV(Context context) {
    super(context);
    bit_dot = BitmapFactory.decodeResource(getResources(),
            R.drawable.ic_launcher);

}

@Override
protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    canvas.drawBitmap(bit_dot, 100, 100, null);
    canvas.drawBitmap(bit_dot, 50, 50, null);
}}