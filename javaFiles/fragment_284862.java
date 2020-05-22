void initiateDialog(){
    //Show Alert
    //Your existing code for Dialog
    AlertDialog alertDialog = builder.create();
    alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.holo_red_light);
    alertDialog.show();
    new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    buttonNotPressedFirst();
                }
            }, FIRST_DELAY);

    }
    void buttonNotPressedFirst(){
         //SEND SMS
    new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    buttonNotPressedSecond();
                }
            }, SECOND_DELAY);
    }
    }

    void buttonNotPressedSecond(){
      //Proceed with phone call
    }