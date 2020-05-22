public class DrawText extends ImageView {

Canvas canvas = new Canvas();
public String text = "";
float pointX = 50;
float pointY = 50;

public DrawText(Context context) {
    super(context);
}

@Override
public void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    Paint paint = new Paint();

    canvas.save();
    paint.setColor(Color.WHITE);
    paint.setTextSize(30);
    paint.setAntiAlias(true);
    canvas.drawText(text, pointX, pointY, paint);
    canvas.restore();
}

public DrawText(Context context, AttributeSet attrs) {
    super(context, attrs);
}

public void setTexto(String text) {
    this.text = text;
    invalidate();
}

@Override
public void invalidate() {
    super.invalidate();
}

public void setXY(float pointX, float pointY) {
    this.pointX = pointX;
    this.pointY = pointY;
    System.out.println("ON TOUCH");
    System.out.println(pointX + pointY);

    invalidate();
}