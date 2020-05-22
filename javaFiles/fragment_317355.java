button.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage(GOOGLE_VOICE_SEARCH_PACKAGE_NAME);
              startActivity(launchIntent);

              final Handler handler = new Handler();
              handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                  Log.d(TAG, "TIMEOUT, reconnecting!");
                }
              }, 10000); //10 second timeout

        }
    });