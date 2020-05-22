AlertDialog.Builder alertbox = new AlertDialog.Builder(MainMenuActivity.this);
        alertbox.setMessage("Please restart the app and download your data again."); // Please Restart Application // "Please restart the app and download your purchase again".
        alertbox.setPositiveButton("YES", new DialogInterface.OnClickListener() 
        {
            public void onClick(DialogInterface arg0, int arg1) 
            {
                    //code
            }
        });

        alertbox.setNegativeButton("NO", new DialogInterface.OnClickListener() 
        {
            public void onClick(DialogInterface arg0, int arg1) 
            {
                //code  
            }
        });

        alertbox.show();