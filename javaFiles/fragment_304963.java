mIntentFilter = new IntentFilter();
  mIntentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
  mIntentFilter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
  mIntentFilter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
  mIntentFilter.addAction(WifiManager.SUPPLICANT_CONNECTION_CHANGE_ACTION);
  registerReceiver(mReceiver, mIntentFilter);




public void onReceive(Context context, Intent intent)
   {
    String action  = intent.getAction();
    if(action.equals(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION))
    {
    }else if(action.equals(WifiManager.WIFI_STATE_CHANGED_ACTION))
    {
     int iTemp = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE,
       WifiManager.WIFI_STATE_UNKNOWN);
     LogUtil.d(LOG_SET, "+++++++-----------wifiStateReceiver------+++++++", DEBUG);
     checkState(iTemp);
    }else if(action.equals(WifiManager.SUPPLICANT_CONNECTION_CHANGE_ACTION))
    {
     DetailedState state =WifiInfo.getDetailedStateOf((SupplicantState)
     intent.getParcelableExtra(WifiManager.EXTRA_SUPPLICANT_CONNECTED));
     changeState(state);
     LogUtil.d(LOG_SET, "------------>>>>SUPPLICANT_STATE_CHANGED_ACTION<<<<<<-------", DEBUG);
    }
    else if(action.equals(WifiManager.NETWORK_STATE_CHANGED_ACTION))
    {
        DetailedState state=
       ((NetworkInfo)intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO)).getDetailedState();
       changeState(state);
     }
   }
   private void changeState(DetailedState aState)
    {
     LogUtil.d(LOG_SET, ">>>>>>>>>>>>>>>>>>changeState<<<<<<<<<<<<<<<<"+aState, DEBUG);
   if (aState == DetailedState.SCANNING)
   {
   Log.d("wifiSupplicanState", "SCANNING");
   }
   else if (aState == DetailedState.CONNECTING)
   {
   Log.d("wifiSupplicanState", "CONNECTING");
   }else if(aState == DetailedState.OBTAINING_IPADDR)
   {
   Log.d("wifiSupplicanState", "OBTAINING_IPADDR");
   }
   else if (aState == DetailedState.CONNECTED)
   {
   Log.d("wifiSupplicanState", "CONNECTED");
   }
   else if (aState == DetailedState.DISCONNECTING)
   {
    Log.d("wifiSupplicanState", "DISCONNECTING");
   }
   else if (aState == DetailedState.DISCONNECTED)
   {
    Log.d("wifiSupplicanState", "DISCONNECTTED");
   }
   else if (aState == DetailedState.FAILED)
   {
   }
  }

  public void checkState(int aInt)
  {
   LogUtil.d(LOG_SET,"==>>>>>>>>checkState<<<<<<<<"+aInt, DEBUG);
   if (aInt == WifiManager.WIFI_STATE_ENABLING)
    {
    Log.d("WifiManager", "WIFI_STATE_ENABLING");
    }
   else if (aInt== WifiManager.WIFI_STATE_ENABLED)
   {
   Log.d("WifiManager", "WIFI_STATE_ENABLED");
    }
    else if (aInt == WifiManager.WIFI_STATE_DISABLING)
    {
    Log.d("WifiManager", "WIFI_STATE_DISABLING");
    }
    else if (aInt == WifiManager.WIFI_STATE_DISABLED)
    {
    Log.d("WifiManager", "WIFI_STATE_DISABLED");
    }
  }