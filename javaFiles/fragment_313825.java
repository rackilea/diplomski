Boolean myBoolean = true;

button.setOnClickListener(new OnClickListener() {
     @Override
     public void onClick(View view) {
          if (myBoolean) {
          //Do the action for the first click
          myBoolean = false;
          } else {
          //Do the action for the second click
          myBoolean = true;
          }
     }
});