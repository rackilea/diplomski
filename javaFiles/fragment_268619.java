protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_user_registration);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sp.edit();

         //Some Async task here

        final File destFile = new File(filesDir, sp.getString(Constants.SharedPreferences.USER_ID,null)+ Constants.S3Bucket.IMAGE_EXTENSION);
        final File downFile = new File(filesDir, Constants.S3Bucket.USER_DIRECTORY + sp.getString(Constants.SharedPreferences.USER_ID,null)+ Constants.S3Bucket.IMAGE_EXTENSION);
        Runnable myRunnable = new Runnable() {

            @Override
            public void run() {

                Log.v(LOG_TAG,"S3 file profile exists "+downFile.getAbsolutePath()+" "+downFile.exists());

                while(!downFile.exists()){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Log.e(LOG_TAG,"Error",e);

                    }
                    Log.v(LOG_TAG,"Inside while loop");
                }

                Log.v(LOG_TAG,"S3 file profile exists after while "+downFile.getAbsolutePath()+" "+downFile.exists());


                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        };

       Handler handler = new Handler();
       handler.post(myRunnable);

    }