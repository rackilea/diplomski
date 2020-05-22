private void ImgAnimation() {

        mHandlerAnimation = new Handler();

        mRunnableAnimation = new Runnable() {
            public void run() {

                  if(endx>startx) 
                  {
                         canvas.drawLine(startx, starty, startx+1, endy, paint);
                         startx = startx + 1;
                         getWindow().getDecorView().findViewById(android.R.id.content).invalidate();
                  }
                  else
                  {
                      bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                      canvas = new Canvas(bitmap);
                      drawingImageView.setImageBitmap(bitmap);
                      startx = 50;
                  }


                mHandlerAnimation.postDelayed(this, 80);
            }
        };

        mHandlerAnimation.postDelayed(mRunnableAnimation, 80);

    }