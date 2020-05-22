public boolean onTouch(View arg0, MotionEvent event) {
    switch (event.getAction()) {
      case MotionEvent.ACTION_DOWN:
        x = event.getX();
        y = event.getY();
        sX = event.getX();
        sY = event.getY();
        fX = fY = dX = dY = sclX = sclY = aniX = aniY = 0;
        break;
      case MotionEvent.ACTION_UP:
        fX = event.getX();
        fY = event.getY();
        dX = fX - sX;
        dY = fY - sY;
        sclX = dX / 30;
        sclY = dY / 30;

        break;
    }
    return true;
}