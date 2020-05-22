ImageView popup = new ImageView(this);    
popup.setOnClickListener(new OnClickListener() {

     @Override
     public void onClick(View v) {
         ((FrameLayout) findViewById(android.R.id.content)).removeView(v);
     } 
});