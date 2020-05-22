public boolean onTouch(View v, MotionEvent event) {
  if (event.getAction() == MotionEvent.ACTION_DOWN){
      int x = (int) event.getX() ;
      int y = (int) event.getY();
      RelativeLayout.LayoutParams lp =new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);; //Assuming you use a RelativeLayout
      ImageView iv=new ImageView(getApplicationContext());
      lp.setMargins(x,y,0,0);
      iv.setLayoutParams(lp);
      iv.setImageDrawable(getResources().getDrawable(/*id of your image*/));
      ((ViewGroup)v).addView(iv);
  }