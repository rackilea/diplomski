public class MyView extends View {
Rect bitmapRect;
public MyView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
}

public MyView(Context context, AttributeSet attrs) {
    super(context, attrs);
}

@Override
protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);    //To change body of overridden methods use File | Settings | File Templates.

    Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher);

    Rect source = new Rect(0,0,bitmap.getWidth(), bitmap.getHeight());
    bitmapRect = new Rect(0,0, bitmap.getWidth(), bitmap.getHeight());

    canvas.drawBitmap(bitmap, source, bitmapRect, new Paint());

}

@Override
public boolean onTouchEvent(MotionEvent event) {
    int x = (int)event.getX();
    int y =   (int)event.getY();
    if(null != bitmapRect && bitmapRect.contains(x,y)){
        Toast.makeText(view.getContext(), "this works", Toast.LENGTH_LONG).show();
    }


    return super.onTouchEvent(event);    //To change body of overridden methods use File | Settings | File Templates.
}