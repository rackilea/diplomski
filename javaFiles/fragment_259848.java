// You can use a FrameLayout to hold the surface view
FrameLayout frameLayout = new FrameLayout(this);
frameLayout.addView(surfaceView);

// Then create a layout to hold everything, for example a RelativeLayout
RelativeLayout relativeLayout= new RelativeLayout(this);
relativeLayout.addView(frameLayout);
relativeLayout.addView(textview1);
relativeLayout.addView(textview2);
setContentView(relativeLayout);