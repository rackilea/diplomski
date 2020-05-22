final View myView = findViewById(R.id.id_of_view);
ViewTreeObserver vto = myView.getViewTreeObserver();
vto.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
  @Override
  public void onGlobalLayout() {
    int viewHeight = myView.getHeight();
    int viewWidth = myView.getWidth();

    // Do what you want with the width and height

    ViewTreeObserver obs = myView.getViewTreeObserver();
    obs.removeGlobalOnLayoutListener(this);
   }
  });