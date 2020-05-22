private void configureBroadcastReciver() {
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent i)
            {
                try
                {
                    String imageDisplayGPSState = (String) i.getExtras().get("btn_imageDisplayGPS");
                    if(imageDisplayGPSState.equals("true"))
                    {
                        MyLocationMapDisplay(true);
                    }
                    else
                    {
                        MyLocationMapDisplay(false);
                    }
                }
                catch (Exception ex)
                {
                    Log.d("MAIN ACTIVITY", ex.getMessage());
                }
            }
        };

        registerReceiver(broadcastReceiver, new IntentFilter("buttons_visible"));
    }