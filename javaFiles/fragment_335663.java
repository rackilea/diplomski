public class TheChainView extends View {
        Bitmap bitmap;
        List<Point> points = new ArrayList<>();

        public TheChainView(Context context, AttributeSet attrs) {
            super(context, attrs);
            bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.heart);
            points.add(new Point(200, 200));
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                case MotionEvent.ACTION_MOVE:
                    points.add(new Point(event.getX(), event.getY()));
                    invalidate();
                    break;
            }
            return true;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            for (Point p : points) {
                canvas.drawBitmap(bitmap, p.x, p.y, null);
            }
        }

        static class Point {
            float x, y;
            Point(float x, float y) {
                this.x = x;
                this.y = y;
            }
        }
    }