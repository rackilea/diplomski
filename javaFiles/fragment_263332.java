onCreate()
{
     setContentView(R.layout.main);
     boolean isTablet = checkDevice();
     callBtn = (Button) findViewById(R.id.call);
     if (isTablet)
     {
        callBtn.setEnabled(false);
        callBtn.setText("Not allowed to make a call");
     }

     callBtn.setOnClickListener( new onClickListener(){
           //Make a call
     });

}

public boolean isTablet()
{

    //Code for identifying. Return true if application is running on tablet
    //return false otherwise

}