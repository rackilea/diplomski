Handler handler=new Handler();

final Runnable r = new Runnable()
{
    public void run() 
    {
           findViewById(getResources().getIdentifier("button" + k, "id",            getPackageName())).setBackgroundResource(R.drawable.button); 

        handler.postDelayed(this, 500);
    }
};

handler.postDelayed(r, 500);