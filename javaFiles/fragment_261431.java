@Override 
 protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState); 
     getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); 
     setContentView(R.layout.activity_main); 

     play.setOnClickListener(new View.OnClickListener() { 
         @Override 
         public void onClick(View view) { 

             TranslateAnimation translateAnimation = new TranslateAnimation(0, 100, 0, 0); 
             translateAnimation.setDuration(1000); 
             view.startAnimation(translateAnimation); 

         } 
    }); 
}