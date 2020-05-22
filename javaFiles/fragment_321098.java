void iterate() {
     Canvas c = null;
     try {
         c = sHolder.lockCanvas(null);
         synchronized (sHolder) {
             doDraw(c);
             powerUps();
         }
     } finally {
         if (c != null) {
             sHolder.unlockCanvasAndPost(c);
         }
     }
     this.handler.post(this.iterateRunnable);
}

void onResume() {
    this.handler = new Handler();
    this.iterateRunnable = new Runnable() {
        @Override public void run() { iterate(); }
    };
    this.handler.post(this.iterateRunnable);
}