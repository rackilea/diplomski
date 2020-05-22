//Kept at class level
 private Runnable r;
 private Handler temp;


introButton = (Button) findViewById(R.id.introButtonID);
    introButton.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
           startActivity();
        }
    });

 r=new Runnable() {

        @Override
        public void run() {
            // TODO Auto-generated method stub
           startActivity();
        }
    };

 temp=new Handler();
temp.postDelayed(r, SPLASH_TIME_OUT);
}

private void startActivity(){
Intent intent00 = new Intent(Intro.this, MPL.class);
startActivity(intent00);
temp.removeCallbacks(r);
finish();
}