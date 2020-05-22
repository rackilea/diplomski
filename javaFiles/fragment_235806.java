about.setMessage("About The Giveaway");

    about.setPositiveButton("Rate", new DialogInterface.OnClickListener() 
    {
        Intent market = new Intent("android.intent.action.VIEW",Uri.parse("https://market.android.com/details?id=com.synamegames.giveaway"));

        public void onClick(DialogInterface arg0, int arg1) 
        {
                    //action
            startActivity(market);  

        }
    });

    about.setNegativeButton("Close", new DialogInterface.OnClickListener() 
    {
        public void onClick(DialogInterface arg0, int arg1) 
        {

        }
    });

    about.show();