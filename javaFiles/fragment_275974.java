Button btnDownload = (Button) findViewById(R.id.DownloadView);
  Button btnApp = (Button) findViewById(R.id.AppView);

  btnDownload.setOnClickListener(handler);
  btnApp.setOnClickListener(handler);

  View.OnClickListener handler = new View.OnClickListener(){

  public void onClick(View v) {

    if(v==btnDownload){ 
            // doStuff
            Intent intentMain = new Intent(CurrentActivity.this , 
                                           SecondActivity.class);
            CurrentActivity.this.startActivity(intentMain);
            Log.i("Content "," Main layout ");
    }

    if(v==btnApp){ 
            // doStuff
            Intent intentApp = new Intent(CurrentActivity.this, 
                                          ThirdActivity.class);

            CurrentActivity.this.startActivity(intentApp);

            Log.i("Content "," App layout ");

    }
   }
  };