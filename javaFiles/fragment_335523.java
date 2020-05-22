AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(yoursplashscreen.this);

       dialogBuilder.setTitle("Promo Code");
dialogBuilder.setMessage("Type in 'VC2001' for a 10% discount. Only applicable for VC-20U");


        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                // finish your splash screen here and set intent to your new activity
                finish();
                Intent i = new Intent(getBaseContext(), MainActivity.class);
                startActivity(i);
            }
        });
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();