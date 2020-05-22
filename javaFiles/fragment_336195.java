protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint p = new Paint();
            p.setColor(Color.RED);
            DashPathEffect dashPath = new DashPathEffect(new float[]{5,5}, (float)1.0);

            p.setPathEffect(dashPath);
            p.setStyle(Style.STROKE);


            for (int i = 0; i < 7; i ++) {
                canvas.drawCircle(100, 100, 50+(i*10), p);
            }


            invalidate();
        }