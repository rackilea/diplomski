public class DrawObject {

    Paint paint = new Paint();

    public void setColor(int color) {
        paint.setColor(color);
    }

    // I want to draw an arrow to instead of a line
    public void drawArrow(Canvas canvas, float startPointX, float startPointY, float endPointX, float endPointY) {
        canvas.drawLine(startPointX, startPointY, endPointX, endPointY, paint);
        // draw the rest of the arrow here
    }
}