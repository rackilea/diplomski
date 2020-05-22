public boolean onTouch(View v, MotionEvent event) {
    this.touchX = (int)event.getX();
    this.touchY = (int)event.getY();
    Log.i("STATE", Integer.toString(this.touchX));
    return true;
}



@Override
protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    Log.i("STATE", Integer.toString(this.touchX));
}