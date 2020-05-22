if (isInternetPresent) {              
    // Internet Connection is Present
   // make HTTP requests
    AlertDialog.Builder builder = new   AlertDialog.Builder(AndroidDetectInternetConnectionActivity.this);
    builder.setMessage("You have network connection.")
        .setTitle("Internet Connection")
        .setCancelable(false);

                alert.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which){ 
                      // Do call some activity. Do what you    wish to;
         startActivity(new  Intent(AndroidDetectInternetConnectionActivity.this,MainActivity2.class));
                  }
               }); 
          AlertDialog alert = builder.create();
                alert.show();