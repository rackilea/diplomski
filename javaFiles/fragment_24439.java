Button play = (Button)findViewById(R.id.play);           
  play.setOnClickListener(new View.OnClickListener() {

                 @Override
                 public void onClick(View view) {
                       Intent i =new Intent(getApplicationContext(), aselectmenu.class);
                       displayInterstitial();
                       startActivity(i);
                     }               
             });