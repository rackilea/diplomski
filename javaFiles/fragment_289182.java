@Override
public boolean performClick() {
    return super.performClick();
}

@Override
public boolean onTouch(View view, MotionEvent event) {
    view.performClick();
    if (isPointInCircle((int) event.getX(), (int) event.getY())) {
        // do what you want to do and get rid of the next two lines
        String color = (((ArcView) view).color == Color.RED) ? "RED" : (((ArcView) view).color == Color.BLACK) ? "BLACK" : "BLUE";
        Toast.makeText(context, color, Toast.LENGTH_SHORT).show();
        return true;
    }
    return false;
}

private boolean isPointInCircle(int clickX, int clickY) {
    return (clickX - x) * (clickX - x) + (clickY - y) * (clickY - y) <= radius * radius;
}