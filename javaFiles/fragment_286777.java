public void onDraw(Canvas canvas) {

    //Code to Measure the Screen width in pixels

    WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
    Display display = wm.getDefaultDisplay();
    Point size = new Point();
    display.getSize(size);
    int width = size.x;

    paint.setColor(Color.RED);
    canvas.drawRect(0, 0, 5, canvas.getHeight(), paint );

    paint.setColor(Color.RED);
    canvas.drawRect(canvas.getWidth()-width, 0, 5, canvas.getHeight(), paint );
}