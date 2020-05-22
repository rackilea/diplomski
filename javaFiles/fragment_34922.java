final SurfaceView s = (SurfaceView) findViewById(R.id.surface);

final RectF rect = new RectF();

s.setOnTouchListener(new OnTouchListener() {

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        SurfaceHolder holder = s.getHolder();
        Canvas canvas = holder.lockCanvas();

        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            Log.d("action", "down");
            rect.left = event.getX();
            rect.top = event.getY();
        }
        if(event.getAction() == MotionEvent.ACTION_UP){
            Log.d("action", "up");
            rect.right = event.getX();
            rect.bottom = event.getY();

            Paint paint = new Paint();
            paint.setColor(Color.RED);
            canvas.drawRect(rect, paint);
        }

        holder.unlockCanvasAndPost(canvas);
        return true;
    }
});