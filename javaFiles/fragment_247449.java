SharedPreferences sp=getSharedPreferences("Button", Context.MODE_PRIVATE);
SharedPreferences.Editor Ed=sp.edit();

// get status of button to set backround from SharedPreferences in oncrate() methosd

   if(sp.getBoolean("button1",false)){
        b1.setBackgroundColor(Color.WHITE);
    }else {
        b1.setBackgroundColor(Color.GREEN);
    }
    if(sp.getBoolean("button2",false)){
        b2.setBackgroundColor(Color.WHITE);
    }else {
        b2.setBackgroundColor(Color.GREEN);
    }


// set button background status in SharedPreferences
b1.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
       b1.setBackgroundColor(Color.GREEN);
       b2.setBackgroundColor(Color.WHITE);
       Ed.putBoolean("button1", true);
       Ed.commit();

        }
     }
  });

   b2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
               b1.setBackgroundColor(Color.WHITE);
               b2.setBackgroundColor(Color.RED);
               Ed.putBoolean("button2", true);
               Ed.commit();

             }
           }
      });