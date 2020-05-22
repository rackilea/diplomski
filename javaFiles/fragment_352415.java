import android.content.Context;
    import android.graphics.Canvas;
    import android.graphics.Color;
    import android.graphics.Paint;
    import android.view.View;

    public class LineView extends View {
    Paint paint = new Paint();

  public LineView(Context context, AttributeSet attrs) {
      super(context, attrs);
      }

    public LineView(Context context, AttributeSet attrs, int defstyle) {
    super(context, attrs, defstyle );
      }


    public LineView(Context context) {
    super(context);
    paint.setColor(Color.BLACK);
}

@Override
public void onDraw(Canvas canvas) {
        canvas.drawLine(0, 0, 20, 20, paint);
}

}