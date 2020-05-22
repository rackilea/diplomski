setContentView(R.layout.yourlayout); //all this code in your activity
DrawView drawView= new DrawView(this);
ViewGroup frameLayout = (ViewGroup) findViewById(R.id.content);

drawView.setLayoutParams(new 
FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
FrameLayout.LayoutParams.WRAP_CONTENT));
frameLayout.addView(drawView);