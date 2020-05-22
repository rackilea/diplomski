Handler hl_timeout = new Handler();

/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    try{
        hl_timeout.postDelayed(DoOnTimeOut, 15000);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
}

//  Toast
Thread DoOnTimeOut = new Thread() {
    public void run() {
        try{
            Toast.makeText(getApplicationContext(), "System is idle", Toast.LENGTH_LONG).show();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
};

@Override
public void onUserInteraction()
{
    super.onUserInteraction();
    //Remove any previous callback
    try{
    hl_timeout.removeCallbacks(DoOnTimeOut);
    hl_timeout.postDelayed(DoOnTimeOut, 15000);
    }catch(Exception e)
    {
        e.printStackTrace();
    }
}