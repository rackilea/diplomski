public boolean onTouchEvent(MotionEvent event) {
    float touchX = event.getX();
    float touchY = event.getY();
    //respond to down, move and up events
    switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
            drawPath.moveTo(touchX, touchY);
            points.add(new Pair<Float, Float>(touchX, touchY));
            break;
        case MotionEvent.ACTION_MOVE:
            drawPath.lineTo(touchX, touchY);
            points.add(new Pair<Float, Float>(touchX, touchY));
            break;
        case MotionEvent.ACTION_UP:
            drawPath.lineTo(touchX, touchY);
            System.out.println(touchX +", " +touchY);

            points.add(new Pair<Float, Float>(touchX, touchY));
            //At this point you might want to
            //store this array somewhere 
            //so you can use it to redraw later if needed

            drawCanvas.drawPath(drawPath, drawPaint);
            drawPath.reset();
            break;
        default:
            return false;
    }
    //redraw
    invalidate();
    return true;
}