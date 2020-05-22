setContentView(R.layout.main);
    pref = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE);
    Log.v("","onCreate is calling");
    if(pref.getBoolean("activity_executed", false))
    {
         Log.v("","Before if called");
        setContentView(R.layout.menu_frame);
         Log.v("","after if called");
         new Handler().postDelayed(csRunnable1, 3000);

    } 
    else 
    {
       new Handler().postDelayed(csRunnable2, 3000);  
        Editor ed = pref.edit();
        ed.putBoolean("activity_executed", true);
        ed.commit();

    }


}
Runnable csRunnable1=new Runnable() 
{       
    @Override
    public void run() 
    {
         Intent intent = new Intent(SplashScreen.this, SplashActivity.class);
            startActivity(intent);
            finish();

    }
};
Runnable csRunnable2=new Runnable() 
 {      
    @Override
    public void run() 
    {
         Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
            startActivity(intent);
            finish();

    }
};