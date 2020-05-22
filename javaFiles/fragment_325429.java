public void testBitmap(){
  LinearLayout l = new LinearLayout(getContext());
  l.layout(0, 0, 100, 100);
  MyCustomView myView = new MyCustomView(getContext());
  myView.layout(0, 0, 100, 100);
  l.addView(myView);
  //draw things in myView
  myView.getBitmap();
}