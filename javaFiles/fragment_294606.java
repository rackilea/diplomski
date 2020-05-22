private ProgressDialog progressBar;

    static LoadingScreen instance;


    static LoadingScreen getInstance()
    {
        return instance;
    }


    public int getPort()
    {
        return portnum;
    }

    public String getIP()
    {
        return ip_text;
    }


    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState); 
        setContentView(R.layout.blank_activity);

        instance = this;

        progressBar = new ProgressDialog(this);
        progressBar.setCancelable(true);
        progressBar.setMessage("Loading...");
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER); 
        progressBar.setIndeterminate(true);
        progressBar.show();


        final Intent mainIntent = new Intent(LoadingScreen.this, MainActivity.class); 

        new Handler().postDelayed(new Runnable(){ 

            @Override 
            public void run() { 

                try 
                {
                    Thread.sleep(1000);
                } 
                catch (InterruptedException e) 
                {
                    e.printStackTrace();
                }

                startActivity(mainIntent);              
                finish(); 

                progressBar.cancel();
            } 
        }, 2000);
    }