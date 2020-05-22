class scan extends AsyncTask<String, Void, Void> {
     ArrayList<ClientScanResult> clients;
     Context context;

...

then initialize your `clients` in `doInBackground()`

clients = wifiApManager.getClientList(false);