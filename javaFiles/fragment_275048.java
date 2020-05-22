ImageButton launchApp1=(ImageButton) findViewById(R.id.button3);

    launchApp1.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub

                    if(app1Installed){
                        Intent LaunchIntent = getPackageManager()
                                .getLaunchIntentForPackage("com.example.cameraphonegap");
                        startActivity(LaunchIntent);}else{
                             Log.d("installed","App1 not installed on your phone");
                              Toast.makeText(getApplicationContext(),
                              "App1 Not Installed ", Toast.LENGTH_SHORT).show(); }

                }
            });