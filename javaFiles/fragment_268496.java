timeOnTextView.postDelayed(new Runnable() {
      @Override
      public void run() {
        seconds++;
        timeOnTextView.postDelayed(this, 1000);
      }
    }, 1000);