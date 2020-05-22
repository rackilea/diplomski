ViewTreeObserver viewTreeObserver = YOURLAYOUT.getViewTreeObserver();
if (viewTreeObserver.isAlive()) {
viewTreeObserver.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
      public void onGlobalLayout() {
         YOURLAYOUT.getViewTreeObserver().removeGlobalOnLayoutListener(this);
         //do some things
         //YOURLAYOUT.getWidth() should give a correct answer
      }
});
}