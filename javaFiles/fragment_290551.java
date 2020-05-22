Thread.sleep(50);
 time = (time + 1) % 4;
 image = images[time];
 ((Activity) context).runOnUiThread(new Runnable() {
      @Override
      public void run() {
          invalidate();
      }
 };