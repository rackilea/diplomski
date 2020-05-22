image.animate()
        .xBy(screenWidth-200)
        .setDuration(5000)
        .withEndAction(new Runnable() {
          @Override
          public void run() {
            // Do something when animation ends
          }
        })
        .start();