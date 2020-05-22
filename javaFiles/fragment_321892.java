private Paint mPaint = new Paint();
     @Override
        protected void onDraw(Canvas canvas) {
            for(int i = 0 ; i<n ;i++){
               mPaint.setColor(color);
               canvas.drawCircle(cx,cy,radius,mPaint);
            }

        }