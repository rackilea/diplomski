final FlingGallery g1 = ...//from somewhere
    final FlingGallery g2 = ...//from somewhere

    g1.setOnFlingListener(new OnFlingListener() {
            @Override
            public void onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
               g2.onFling(e1, e2, velocityX, velocityY);
            }
    });