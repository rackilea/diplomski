public class Circle {

    public Paint paint;
    public int y;

    public Circle(int y, int r, int g, int b) {
        paint = new Paint();
        paint.setColor(Color.rgb(r,g,b));

        this.y=y;
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle(30, this.y,30, paint);
    }
}