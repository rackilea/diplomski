@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_alert);


        wm = (WifiManager) getSystemService(WIFI_SERVICE);

        Handler handler = new Handler();
     handler.postDelayed(new Runnable() {
        public void run() {
        if(!wm.isWifiEnabled()) {
        runOnUiThread(new Runnable() {
                public void run() {
                if(pd == null)
                    pd = ProgressDialog.show(this, "Network Error!!", "Network not found.Please make sure there is presence of any kind of network connection!!");
                }
            });

        }else{
        runOnUiThread(new Runnable() {
                public void run() {
                 if(pd != null)
                    pd.dismiss();
                 Intent in=new Intent(Alert.this,WebPageView.class);
                 startActivity(in); 
                }
            });


        }
        handler.postDelayed(this, 5000); //now is every 2 minutes
        }
     }, 5000);

    }