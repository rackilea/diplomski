public class YourView extends View {
    // class attributes   
    private MyPoint touchPoint;

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                touchPoint = new MyPoint(event.getX(), event.getY());
                drawCanvas.drawText(touchPoint.toString(), canvasPaint);
                break;

            // more!!!