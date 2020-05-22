btnNextScreen.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

             //create new intent
             Intent nextScreen = new Intent(getApplicationContext(), SecondScreen.class);
             startActivity(nextScreen);
         }
 });