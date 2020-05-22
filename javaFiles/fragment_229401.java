private Button mLanchServiceBtn;
    private SecondService.LocalBinder mBinder;
    private ServiceConnection mConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName className, IBinder service) {
                mBinder = (LocalBinder) service;
            }
            @Override
            public void onServiceDisconnected(ComponentName arg0) {
            }
     };
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            mLanchServiceBtn=(Button) findViewById(R.id.launch_btn);

            mLanchServiceBtn.setOnClickListener(this);



            //starting second service in activity

            Intent launch=new Intent(this,SecondService.class);
            startService(launch);

            //Binding to it 
            bindService(launch, mConnection, BIND_AUTO_CREATE);
        }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();
            if (id == R.id.action_settings) {
                return true;
            }
            return super.onOptionsItemSelected(item);
        }


        @Override
        public void onClick(View v) {

           //Starting FirstService also from MainActivity
            Intent launch=new Intent(this,FirstService.class);
            startService(launch);

        }
    }