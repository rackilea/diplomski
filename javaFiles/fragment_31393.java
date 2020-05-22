private class SimpleMotion extends View {

        public SimpleMotion(Context context) {
            super(context);

            new Thread(new Runnable() {
                public void run() {
                    while(true){
                        try {
                            Thread.sleep(75);
                            y++;
                            postInvalidate();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
              }).start();
        }

        @Override protected void onDraw(Canvas canvas) {

            float x = canvas.getWidth() / 2;
            canvas.drawColor(Color.WHITE);
            canvas.drawCircle(x, y, 30, paint);  
//            if(System.currentTimeMillis() - now > delay) y++;    
//            invalidate();
        }
    }